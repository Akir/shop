package shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.CellPhoneMapper;
import shop.model.CellPhone;

@Service
@Transactional
public class CellPhoneServiceImpl implements CellPhoneService {
	private CellPhoneMapper cellPhoneMapper;

	public CellPhoneServiceImpl(CellPhoneMapper cellPhoneMapper) {
		this.cellPhoneMapper = cellPhoneMapper;
	}

	public List<CellPhone> findAllByCondition(CellPhone cellPhone) {
		return cellPhoneMapper.findAllByCondition(cellPhone);
	}

	public CellPhone findOne(long id) {
		return cellPhoneMapper.findOne(id);
	}

	public boolean shoppingCartExistGoods(long username_id, long cellphone_id) {
		return cellPhoneMapper.shoppingCartExistGoods(username_id, cellphone_id);
	}

	public void addQuantity(long username_id, long cellphone_id) {
		cellPhoneMapper.addQuantity(username_id, cellphone_id);
	}

	public void createShoppingCart(long username_id, long cellphone_id) {
		cellPhoneMapper.createShoppingCart(username_id, cellphone_id);
	}

}
