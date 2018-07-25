package shop.mapper;

import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {

	void create(@Param(value = "order_id") Long order_id, 
				@Param(value = "cellphone_id") long cellphone_id, 
				@Param(value = "quantity") int quantity);

}
