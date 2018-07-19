package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mapper.UsernameMapper;
import shop.model.Username;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UsernameMapper usernameMapper;

	@Autowired
	public UserDetailsServiceImpl(UsernameMapper usernameMapper) {
		this.usernameMapper = usernameMapper;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Username username1 = usernameMapper.findOneByUsername(username);
		if (username1 == null) {
			System.out.println(username+"--------------------------");
			throw new UsernameNotFoundException("该用户名不存在");
		}
		return new UserDetailsImpl(username1);
	}

}
