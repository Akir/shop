package shop.mapper;

import java.util.List;

import shop.model.ShoppingCartItem;

public interface ShoppingCartMapper {
	List<ShoppingCartItem> findShoppingCart(long id);
}
