package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

		// execute the query and get the results list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (customer.getId() != 0) {
			// update the customer
			currentSession.update(customer);
		} else {
			// save the student
			currentSession.save(customer);
		}

	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Customer
		Customer Customer = currentSession.get(Customer.class, id);

		// delete Customer
		currentSession.delete(Customer);

	}

}
