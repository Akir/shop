package shop.controller.form;

import shop.model.Brand;
import shop.model.CellPhone;

public class CellPhoneForm {
	private long id;
	private String model;
	private String os;
	private String cpu;
	private int ram;
	private int storage;
	private String color;
	private int price;
	private String description;
	private long brandId;
	private String brandName;
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
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public CellPhone toCellPhone() {
		CellPhone cellPhone = new CellPhone();
		cellPhone.setId(id);
		cellPhone.setModel(model);
		cellPhone.setOs(os);
		cellPhone.setCpu(cpu);
		cellPhone.setRam(ram);
		cellPhone.setStorage(storage);
		cellPhone.setPrice(price);
		cellPhone.setDescription(description);
		Brand brand = new Brand();
		brand.setId(brandId);
		brand.setName(brandName);
		cellPhone.setBrand(brand);
		return cellPhone;
	}
}
