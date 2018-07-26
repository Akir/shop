package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.ShoppingCartItem;

public interface ShoppingCartMapper {
	List<ShoppingCartItem> findShoppingCart(long id);

	void reduceQuantity(@Param("username_id") long id, 
						@Param("cellphone_id") long cellphone_id);

	void increaseQuantity(@Param("username_id") long id, 
						@Param("cellphone_id") long cellphone_id);

	void deleteShoppingCartItem(@Param("username_id") long id, 
						@Param("cellphone_id") long cellphone_id);

	void deleteShoppingCart(long id);
}
