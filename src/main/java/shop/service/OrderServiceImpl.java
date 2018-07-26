package shop.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.OrderItemMapper;
import shop.mapper.OrderMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.Order;
import shop.model.ShoppingCartItem;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	private OrderMapper orderMapper;
	private OrderItemMapper orderItemMapper;
	private ShoppingCartMapper shoppingCartMapper;

	public OrderServiceImpl(OrderMapper orderMapper, OrderItemMapper orderItemMapper,
			ShoppingCartMapper shoppingCartMapper) {
		this.orderMapper = orderMapper;
		this.orderItemMapper = orderItemMapper;
		this.shoppingCartMapper = shoppingCartMapper;
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
		return orderMapper.findAll(userid);
	}
}
