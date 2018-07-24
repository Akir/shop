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
	
	public List<ShippingAddress> findAll() {
		return shippingAddressMapper.findAll();
	}

}
