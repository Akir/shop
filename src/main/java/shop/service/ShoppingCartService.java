package shop.service;

import shop.model.ShoppingCart;

public interface ShoppingCartService {

	void addCart(long user_id, long cellphone_id);

	ShoppingCart findShoppingCart(long id);

	void operateShoppingCart(String operate, long id, int quantity);

}
