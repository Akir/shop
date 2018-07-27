package shop.service;

import java.util.List;

import shop.model.Order;
import shop.model.ShoppingCartItem;

public interface OrderService {

	void create(Order order, List<ShoppingCartItem> shoppingCartItems);

	List<Order> findAll(long userid);

	void updateAddress(Long id, Long addressid, long userid);

}
