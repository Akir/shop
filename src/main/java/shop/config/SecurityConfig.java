package shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	private UserDetailsService userDetailsService;
	
	public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler,
			UserDetailsService userDetailsService) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
		this.userDetailsService = userDetailsService;
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
				.successHandler(authenticationSuccessHandler)
				
			.and()
			
			.rememberMe()
				.tokenValiditySeconds(7*24*3600)
				.key("q123456")
				.userDetailsService(userDetailsService);
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
}
