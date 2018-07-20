package shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.mapper.CellPhoneMapper;
import shop.model.CellPhone;

@Service
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
}
