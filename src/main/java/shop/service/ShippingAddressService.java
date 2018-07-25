package shop.service;

import java.util.List;

import shop.model.ShippingAddress;

public interface ShippingAddressService {

	List<ShippingAddress> findAll();

	void create(ShippingAddress shippingAddress);

	void delete(Long id);

	ShippingAddress findOne(Long id);

	void update(ShippingAddress shippingAddress);

}
