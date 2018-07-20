package shop.service;

import java.util.List;

import shop.model.CellPhone;

public interface CellPhoneService {

	List<CellPhone> findAllByCondition(CellPhone cellPhone);

	CellPhone findOne(long id);

}
