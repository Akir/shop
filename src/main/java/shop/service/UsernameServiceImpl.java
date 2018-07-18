package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.mapper.UsernameMapper;
import shop.model.Username;

@Service
public class UsernameServiceImpl implements UsernameService {
	private UsernameMapper usernameMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsernameServiceImpl(UsernameMapper usernameMapper, PasswordEncoder passwordEncoder) {
		this.usernameMapper = usernameMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void create(Username username) {
		String encodedPassword = passwordEncoder.encode(username.getPassword());
		username.setPassword(encodedPassword);
		usernameMapper.create(username);
	}

}
