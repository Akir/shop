package shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.mapper.CellPhoneMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.CellPhone;
import shop.model.ShoppingCartItem;

@Service
public class CellPhoneServiceImpl implements CellPhoneService {
	private CellPhoneMapper cellPhoneMapper;
	private ShoppingCartMapper shoppingCartMapper;

	public CellPhoneServiceImpl(CellPhoneMapper cellPhoneMapper, ShoppingCartMapper shoppingCartMapper) {
		this.cellPhoneMapper = cellPhoneMapper;
		this.shoppingCartMapper = shoppingCartMapper;
	}

	public List<CellPhone> findAllByCondition(CellPhone cellPhone) {
		return cellPhoneMapper.findAllByCondition(cellPhone);
	}

	public CellPhone findOne(long id) {
		return cellPhoneMapper.findOne(id);
	}

	public boolean shoppingCartExistGoods(long username_id, long cellphone_id) {
		return cellPhoneMapper.shoppingCartExistGoods(username_id, cellphone_id);
	}

	public void addQuantity(long username_id, long cellphone_id) {
		cellPhoneMapper.addQuantity(username_id, cellphone_id);
	}

	public void createShoppingCart(long username_id, long cellphone_id) {
		cellPhoneMapper.createShoppingCart(username_id, cellphone_id);
	}

	public List<ShoppingCartItem> findShoppingCart(long id) {
		return shoppingCartMapper.findShoppingCart(id);
	}
}
