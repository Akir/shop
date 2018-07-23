package shop.service;

import java.util.List;

import shop.model.CellPhone;
import shop.model.ShoppingCartItem;

public interface CellPhoneService {

	List<CellPhone> findAllByCondition(CellPhone cellPhone);

	CellPhone findOne(long id);

	boolean shoppingCartExistGoods(long username_id, long cellphone_id);

	void addQuantity(long username_id, long cellphone_id);

	void createShoppingCart(long username_id, long cellphone_id);

	List<ShoppingCartItem> findShoppingCart(long id);

}
