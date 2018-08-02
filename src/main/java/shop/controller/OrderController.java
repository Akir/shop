package shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.config.UserDetailsImpl;
import shop.model.Order;
import shop.model.ShoppingCart;
import shop.model.ShoppingCartItem;
import shop.model.Username;
import shop.service.OrderService;
import shop.service.ShippingAddressService;
import shop.service.ShoppingCartService;

@Controller
public class OrderController {
	private OrderService orderService;
	private ShippingAddressService shippingAddressService;
	private ShoppingCartService shoppingCartService;

	public OrderController(OrderService orderService, ShippingAddressService shippingAddressService,
			ShoppingCartService shoppingCartService) {
		this.orderService = orderService;
		this.shippingAddressService = shippingAddressService;
		this.shoppingCartService = shoppingCartService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/order/add")
	public String add(@ModelAttribute Order order, Model model) {
		Username username = OrderController.getCurrentUser();
		model.addAttribute("shoppingCart", shoppingCartService.findShoppingCart(username.getId()));
		model.addAttribute("shippingAddress", shippingAddressService.findAll(username.getId()));
		return "order-add";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/order/add")
	public String create(@ModelAttribute Order order) {
		Username username = OrderController.getCurrentUser();
		ShoppingCart shoppingCarts = shoppingCartService.findShoppingCart(username.getId());
		List<ShoppingCartItem> ShoppingCartItems = shoppingCarts.getShoppingCartItems();
		order.setUsername(username);
		orderService.create(order, ShoppingCartItems);
		return "redirect:/uc/order";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/order")
	public String order(Model model) {
		Username username = OrderController.getCurrentUser();
		model.addAttribute("orders", orderService.findAll(username.getId()));
		return "order";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/order/address/{id}")
	public String getAddress(Model model) {
		Username username = OrderController.getCurrentUser();
		model.addAttribute("shippingAddresses", shippingAddressService.findAll(username.getId()));
		return "order-address";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/order/address/{id}")
	public String updateAddress(@PathVariable Long id, @RequestParam Long addressId) {
		Username username = OrderController.getCurrentUser();
		orderService.updateAddress(id, addressId, username.getId());
		return "redirect:/uc/order";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/order/{id}/pay", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pay(@PathVariable Long id) {
		Username username = OrderController.getCurrentUser();
		return orderService.payForm(id, username.getId());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/order/sync-pay-cb")
	public String payOk(@RequestParam Map<String, String> paramMap) {
		orderService.verifySignature(paramMap);
		return "pay-ok";
	}
	
	private static Username getCurrentUser() {
		UserDetailsImpl ud = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Username u = ud.getUser();
		return u;
	}
}
