package gr.hua.dit.springmvc1.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	// inject the customer dao
		@Autowired
		private CustomerDAO customerDAO;
	
	@GetMapping("/customers")
	public List<Customer>  getCustomers() {
		List<Customer> customers = customerDAO.getCustomers();
		return customers;

		
	}


}
