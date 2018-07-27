package shop.model;

public class OrderItem {
	private Long orderId;
	private CellPhone cellPhone;
	private Integer quantity;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public CellPhone getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(CellPhone cellPhone) {
		this.cellPhone = cellPhone;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
