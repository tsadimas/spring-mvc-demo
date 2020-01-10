package gr.hua.dit.springmvc1.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)

public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password, enabled from user where username=?")
				.authoritiesByUsernameQuery("select username, authority from authorities where username=?");

	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	 @Configuration
	    @Order(1)
	    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{
	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	  http.csrf().disable()
	              .antMatcher("/api/**")
	              .authorizeRequests()
	                  .anyRequest().authenticated()
	                  .and()
	              .httpBasic();
	        }
	    }

	    @Configuration
	    @Order(2)
	    public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter{

	        @Override
	        public void configure(WebSecurity web) throws Exception {
	    		web.ignoring().antMatchers("/resources/**");
	        }

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/authUser").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/403");
	        }
	    }
	
	
}
