package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.Order;

public interface OrderMapper {

	void create(Order order);

	List<Order> findAll(long userid);

	void updateAddress(@Param("id") Long id, 
						@Param("addressid") Long addressid, 
						@Param("userid") long userid);

}
