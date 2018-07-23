package shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.CellPhoneMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.ShoppingCart;
import shop.model.ShoppingCartItem;

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
		List<ShoppingCartItem> shoppingCartItems = shoppingCartMapper.findShoppingCart(id);
		long sum = 0;
		for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
			sum += shoppingCartItem.getCellPhone().getPrice() * shoppingCartItem.getQuantity();
		}
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		shoppingCart.setTotalAmount(sum);
		return shoppingCart;
	}

	public void operateShoppingCart(String operate, long id, int quantity) {
		String[] str = operate.split(":");
		long cellphone_id = Long.parseLong(str[0]);
		int num = Integer.parseInt(str[1]);
		switch (num) {
		case 1:
			if(quantity == 1) {
				shoppingCartMapper.deleteShoppingCartItem(id, cellphone_id);
			}else if(quantity > 1) {
				shoppingCartMapper.reduceQuantity(id, cellphone_id);
			}
			break;
		case 2:
			shoppingCartMapper.increaseQuantity(id, cellphone_id);
			break;
		case 3:
			shoppingCartMapper.deleteShoppingCartItem(id, cellphone_id);
			break;
		}
	}

}
