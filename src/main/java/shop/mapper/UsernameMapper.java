package shop.mapper;

import shop.model.Username;

public interface UsernameMapper {

	void create(Username username);

	Username findOneByUsername(String username);

	void updateDate(Username username);
	
	boolean existUsername(String username);

}
