package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.ShippingAddress;

public interface ShippingAddressMapper {
	List<ShippingAddress> findAll(long userid);
	
	void create(ShippingAddress shippingAddress);
	
	void delete(@Param("id") Long id, @Param("userid") long userid);
	
	void update(ShippingAddress shippingAddress);

	ShippingAddress findOne(@Param("id") Long id, @Param("userid") long userid);
}
