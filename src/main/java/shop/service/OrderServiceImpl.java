package shop.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mapper.OrderItemMapper;
import shop.mapper.OrderMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.Order;
import shop.model.OrderItem;
import shop.model.ShoppingCartItem;
import shop.service.exception.AlipaySignatureException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderMapper orderMapper;
	private OrderItemMapper orderItemMapper;
	private ShoppingCartMapper shoppingCartMapper;
	private AlipayClient alipayClient;
	private String alipayReturnUrl;
    private String alipayNotifyUrl;
    private ObjectMapper objectMapper;
    private String alipayPublicKey;

	public OrderServiceImpl(OrderMapper orderMapper, OrderItemMapper orderItemMapper,
			ShoppingCartMapper shoppingCartMapper, AlipayClient alipayClient,
			Environment en, ObjectMapper objectMapper) throws IOException {
		this.orderMapper = orderMapper;
		this.orderItemMapper = orderItemMapper;
		this.shoppingCartMapper = shoppingCartMapper;
		this.alipayClient = alipayClient;
		this.alipayReturnUrl = en.getProperty("alipay.returnUrl");
		this.alipayNotifyUrl = en.getProperty("alipay.notifyUrl");
		this.objectMapper = objectMapper;
		this.alipayPublicKey = FileUtils.readFileToString(new File(en.getProperty("alipay.alipayPublicKeyFile")), "utf-8");
	}

	public void create(Order order, List<ShoppingCartItem> shoppingCartItems) {
		order.setDate(new Date());
		orderMapper.create(order);
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			orderItemMapper.create(order.getId(), shoppingCartItem.getCellPhone().getId(), shoppingCartItem.getQuantity());
		}
		shoppingCartMapper.deleteShoppingCart(order.getUsername().getId());
	}

	public List<Order> findAll(long userid) {
		List<Order> orders = orderMapper.findAll(userid);
		for (Order order : orders) {
			totalAmount(order, userid);
		}
		return orders;
	}

	private void totalAmount(Order order, long userid) {
		List<OrderItem> orderItems = orderItemMapper.findAllByOrderId(order.getId(), userid);
		long totalAmount = 0;
		for (OrderItem orderItem : orderItems) {
			totalAmount += orderItem.getCellPhone().getPrice() * orderItem.getQuantity();
		}
		order.setTotalAmount(totalAmount);
		order.setOrderItems(orderItems);
	}

	public void updateAddress(Long id, Long addressid, long userid) {
		if(addressid != null) {
			orderMapper.updateAddress(id, addressid, userid);
		}
	}

	public String payForm(Long id, long userid) {
		Order order = findOne(id, userid);
		totalAmount(order, userid);
		BigDecimal totalAmount = BigDecimal.valueOf(order.getTotalAmount()).divide(BigDecimal.valueOf(100));
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
	    alipayRequest.setReturnUrl(alipayReturnUrl);
	    alipayRequest.setNotifyUrl(alipayNotifyUrl);//在公共参数中设置回跳和通知地址
	    Map<String, Object> bizContent = new HashMap<>();
	    bizContent.put("out_trade_no", "" + id + "-" + new Date().getTime());
	    bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
	    bizContent.put("total_amount", totalAmount);
	    bizContent.put("subject", "shop手机商城订单支付");
	    bizContent.put("body", "TODO 显示订单项概要");
	    try {
	    	alipayRequest.setBizContent(objectMapper.writeValueAsString(bizContent));//填充业务参数
	        return alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	@Override
	public Order findOne(Long id, long userid) {
		return orderMapper.findOne(id, userid);
	}

	@Override
	public void verifySignature(Map<String, String> paramMap) {
		try {
			if(!AlipaySignature.rsaCheckV1(paramMap, alipayPublicKey, "utf-8", "RSA2")) {
				throw new AlipaySignatureException();
			}
		} catch (AlipayApiException e) {
			throw new AlipaySignatureException(e);
		}
	}
}
