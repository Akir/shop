package shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.ShippingAddressMapper;
import shop.model.ShippingAddress;

@Service
@Transactional
public class ShippingAddressServiceImpl implements ShippingAddressService {
	private ShippingAddressMapper shippingAddressMapper;
	
	public ShippingAddressServiceImpl(ShippingAddressMapper shippingAddressMapper) {
		this.shippingAddressMapper = shippingAddressMapper;
	}
	
	public List<ShippingAddress> findAll(long userid) {
		return shippingAddressMapper.findAll(userid);
	}

	public void create(ShippingAddress shippingAddress) {
		shippingAddressMapper.create(shippingAddress);
	}

	public void delete(Long id, long userid) {
		shippingAddressMapper.delete(id, userid);
	}

	public ShippingAddress findOne(Long id, long userid) {
		return shippingAddressMapper.findOne(id, userid);
	}

	public void update(ShippingAddress shippingAddress) {
		shippingAddressMapper.update(shippingAddress);
	}

}
