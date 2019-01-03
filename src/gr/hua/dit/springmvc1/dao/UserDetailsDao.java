package gr.hua.dit.springmvc1.dao;

import gr.hua.dit.springmvc1.entity.User;

public interface UserDetailsDao {
	  User findUserByUsername(String username);
	}
