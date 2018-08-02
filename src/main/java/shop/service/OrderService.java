package shop.service;

import java.util.List;
import java.util.Map;

import shop.model.Order;
import shop.model.ShoppingCartItem;

public interface OrderService {

	void create(Order order, List<ShoppingCartItem> shoppingCartItems);

	List<Order> findAll(long userid);

	void updateAddress(Long id, Long addressid, long userid);

	String payForm(Long id, long userid);
	
	Order findOne(Long id, long userid);

	void verifySignature(Map<String, String> paramMap);

}
