package shop.model;

public class ShoppingCartItem {
	private CellPhone cellPhone;
	private int quantity;
	public CellPhone getCellPhone() {
		return cellPhone;
	}
	public void setCellPhones(CellPhone cellPhone) {
		this.cellPhone = cellPhone;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
