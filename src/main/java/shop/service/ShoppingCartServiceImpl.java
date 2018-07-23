package shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.CellPhoneMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.ShoppingCart;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private CellPhoneMapper cellPhoneMapper;
	private ShoppingCartMapper shoppingCartMapper;

	public ShoppingCartServiceImpl(CellPhoneMapper cellPhoneMapper, ShoppingCartMapper shoppingCartMapper) {
		this.cellPhoneMapper = cellPhoneMapper;
		this.shoppingCartMapper = shoppingCartMapper;
	}

	public void addCart(long user_id, long cellphone_id) {
		if(cellPhoneMapper.shoppingCartExistGoods(user_id, cellphone_id)) {
			cellPhoneMapper.addQuantity(user_id, cellphone_id);
		}else {
			cellPhoneMapper.createShoppingCart(user_id, cellphone_id);
		}
	}

	public ShoppingCart findShoppingCart(long id) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setShoppingCartItems(shoppingCartMapper.findShoppingCart(id));
		return shoppingCart;
	}

}
