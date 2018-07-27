package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.OrderItem;

public interface OrderItemMapper {

	void create(@Param(value = "order_id") Long order_id, 
				@Param(value = "cellphone_id") long cellphone_id, 
				@Param(value = "quantity") int quantity);
	
	List<OrderItem> findAllByOrderId(@Param("orderid") Long orderid, @Param("userid") long userid);
}
