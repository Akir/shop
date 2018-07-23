package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import shop.model.CellPhone;

public interface CellPhoneMapper {

	List<CellPhone> findAllByCondition(CellPhone cellPhone);

	CellPhone findOne(long id);

	boolean shoppingCartExistGoods(@Param(value = "username_id") long username_id,
									@Param(value = "cellphone_id") long cellphone_id);

	void addQuantity(@Param(value = "username_id") long username_id,
					@Param(value = "cellphone_id") long cellphone_id);

	void createShoppingCart(@Param(value = "username_id") long username_id,
							@Param(value = "cellphone_id") long cellphone_id);

	

}
