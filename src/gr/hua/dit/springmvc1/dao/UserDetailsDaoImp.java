package gr.hua.dit.springmvc1.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.User;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);

	}

}
