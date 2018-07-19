package shop.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import shop.mapper.UsernameMapper;
import shop.model.Username;

@Service
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{
	private UsernameMapper usernameMapper;
	
	@Autowired
	public AuthenticationSuccessHandlerImpl(UsernameMapper usernameMapper) {
		this.usernameMapper = usernameMapper;
	}

	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		String name = arg0.getParameter("username");
		Username username = usernameMapper.findOneByUsername(name);
		username.setDate(new Date());
		usernameMapper.updateDate(username);
		arg1.sendRedirect("/shop/");
	}

}
