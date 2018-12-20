package gr.hua.dit.springmvc1.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="gr.hua.dit.springmvc1")
@PropertySource("classpath:application.properties")
public class DemoAppConfing {
	
	@Autowired
	private Environment env;
	
	
	
	private Logger logger = Logger.getLogger(getClass().getName());
	// Define a bean for ViewResolver
	
	
//	@Bean
//	public DataSource securityDataSource() {
//		
//		// Create connection pool
//		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
//		
//		try {
//			
//			logger.info("jdbc.url = " + env.getProperty("jdbc.url"));
//			
//			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
//			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
//			securityDataSource.setUser(env.getProperty("jdbc.user"));
//			securityDataSource.setPassword(env.getProperty("jdbc.password"));
//			
//			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//			securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
//			
//
//		}
//		catch (PropertyVetoException exc) {
//			throw new RuntimeException(exc);
//		}
//		
//		
//		return securityDataSource;
//	}
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}