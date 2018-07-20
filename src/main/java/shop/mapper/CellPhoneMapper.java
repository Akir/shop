package shop.mapper;

import java.util.List;

import shop.model.CellPhone;

public interface CellPhoneMapper {

	List<CellPhone> findAllByCondition(CellPhone cellPhone);

	CellPhone findOne(long id);

}
