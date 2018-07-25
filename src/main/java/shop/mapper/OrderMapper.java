package shop.mapper;

import java.util.List;

import shop.model.Order;

public interface OrderMapper {

	void create(Order order);

	List<Order> findAll();

}
