package gr.hua.dit.springmvc1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.hua.dit.springmvc1.dao.UserDetailsDao;
import gr.hua.dit.springmvc1.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;


@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userDetailsDao.findUserByUsername(username);
		UserBuilder builder = null;
		if (user != null) {

			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);

			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();

	}

}
