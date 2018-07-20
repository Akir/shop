package shop.model;

import shop.controller.form.CellPhoneForm;

public class CellPhone {
	private long id;
	private String model;
	private String os;
	private String cpu;
	private int ram;
	private int storage;
	private String color;
	private int price;
	private String description;
	private Brand brand;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public CellPhoneForm toCellPhoneForm() {
		CellPhoneForm cellPhoneForm = new CellPhoneForm();
		cellPhoneForm.setId(id);
		cellPhoneForm.setOs(os);
		cellPhoneForm.setCpu(cpu);
		cellPhoneForm.setModel(model);
		cellPhoneForm.setRam(ram);
		cellPhoneForm.setStorage(storage);
		cellPhoneForm.setColor(color);
		cellPhoneForm.setDescription(description);
		cellPhoneForm.setBrandId(brand.getId());
		cellPhoneForm.setPrice(price);
		return cellPhoneForm;
	}
}
