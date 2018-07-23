package shop.model;

import java.util.List;

public class ShoppingCart {
	private List<ShoppingCartItem> shoppingCartItems;

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

}
