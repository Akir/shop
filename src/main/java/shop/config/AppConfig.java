package shop.config;

import java.io.File;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("shop")
@MapperScan("shop.mapper")
@PropertySource({"classpath:shop/jdbc.properties", "classpath:shop/alipay.properties"})
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurationSupport {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public DataSource dataSource(Environment en) {
		DriverManagerDataSource ds = new DriverManagerDataSource(
				en.getProperty("jdbc.url"), 
				en.getProperty("jdbc.username"), 
				en.getProperty("jdbc.password"));
		ds.setDriverClassName(en.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("shop/mybatis-comfig.xml"));
		sf.setDataSource(ds);
		return sf;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
	@Bean
	public AlipayClient alipayClient(Environment en) throws IOException {
		return new DefaultAlipayClient(
				"https://openapi.alipay.com/gateway.do",
				en.getProperty("alipay.appId"),
				FileUtils.readFileToString(new File(en.getProperty("alipay.appPrivateKeyFile")), "utf-8"),
				"json",
				"UTF-8",
				FileUtils.readFileToString(new File(en.getProperty("alipay.alipayPublicKeyFile")), "utf-8"),
				"RSA2");
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
