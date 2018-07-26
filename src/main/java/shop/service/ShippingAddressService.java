package shop.service;

import java.util.List;

import shop.model.ShippingAddress;

public interface ShippingAddressService {

	List<ShippingAddress> findAll(long userid);

	void create(ShippingAddress shippingAddress);

	void delete(Long id, long userid);

	ShippingAddress findOne(Long id, long userid);

	void update(ShippingAddress shippingAddress);

}
