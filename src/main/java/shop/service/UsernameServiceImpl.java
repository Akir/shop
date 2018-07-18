package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.UsernameMapper;
import shop.model.Username;

@Service
public class UsernameServiceImpl implements UsernameService {
	private UsernameMapper usernameMapper;
	
	@Autowired
	public UsernameServiceImpl(UsernameMapper usernameMapper) {
		this.usernameMapper = usernameMapper;
	}
	
	public void create(Username username) {
		usernameMapper.create(username);
	}

}
