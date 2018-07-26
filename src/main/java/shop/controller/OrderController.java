package shop.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	private static Username getCurrentUser() {
		UserDetailsImpl ud = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Username u = ud.getUser();
		return u;
	}
}
