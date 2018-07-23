package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.UsernameMapper;
import shop.model.Username;
import shop.service.exception.UsernameExistException;

@Service
@Transactional
public class UsernameServiceImpl implements UsernameService {
	private UsernameMapper usernameMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsernameServiceImpl(UsernameMapper usernameMapper, PasswordEncoder passwordEncoder) {
		this.usernameMapper = usernameMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void create(Username username) {
		if(usernameMapper.existUsername(username.getUsername())) {
			throw new UsernameExistException();
		}
		String encodedPassword = passwordEncoder.encode(username.getPassword());
		username.setPassword(encodedPassword);
		usernameMapper.create(username);
	}

	public Username findUserByName(String username) {
		return usernameMapper.findOneByUsername(username);
	}

}
