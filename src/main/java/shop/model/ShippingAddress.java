package shop.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ShippingAddress {
	private Long id;
	private Username username;
	@Size(min = 2, max = 64, message = "至少2个字")
	private String name;
	@Pattern(regexp = "^1[0-9]{10}$", message = "手机号码不正确")
	private String phoneNumber;
	@Size(min = 5, max = 512, message = "至少5个字")
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Username getUsername() {
		return username;
	}
	public void setUsername(Username username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
