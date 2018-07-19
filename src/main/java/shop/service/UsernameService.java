package shop.service;

import shop.model.Username;

public interface UsernameService {

	void create(Username username);

	Username findUserByName(String username);

}
