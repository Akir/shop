package shop.config;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import shop.model.Username;

public class UserDetailsImpl extends User {

	private Username user;
	
	public UserDetailsImpl(Username username) {
		super(username.getUsername(), 
				username.getPassword(), 
				true, true, true, true, 
				new ArrayList<GrantedAuthority>());
		this.user = username;
	}

	public Username getUser() {
		return user;
	}

}
