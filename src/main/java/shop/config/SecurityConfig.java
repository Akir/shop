package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login")
				.permitAll()
				.antMatchers("/uc/**")
				.authenticated()
//			
//			.and()
//			
//			.sessionManagement()
//				.maximumSessions(1)
//				.sessionRegistry(sessionRegistry())
//				.and()
			
			.and()
			
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.successHandler(authenticationSuccessHandler);
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
}
