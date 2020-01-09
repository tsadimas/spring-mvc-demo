package gr.hua.dit.springmvc1.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerDAO.getCustomers();
		return customers;

	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {

		Customer theCustomer = customerDAO.getCustomer(customerId);

		if (theCustomer == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
		}

		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerDAO.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
		}
		customerDAO.deleteCustomer(customerId);
		return "Deleted customer id - " + customerId;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
	/*	 also just in case the pass an id in JSON ... set id to 0
		 this is force a save of new item ... instead of update
		 sample data (raw-application/json)
		{
			"firstName": "Alekos",
			"lastName": "Sakellarios",
			"email": "alekos@hua.gr"
		}
	*/
		theCustomer.setId(0);
		
		customerDAO.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
	/*	 sample data (raw-application/json)
		{
			"id": "7",
			"firstName": "Alekos-New",
			"lastName": "Sakellarios",
			"email": "alekos@hua.gr"
		}
	*/
		
		customerDAO.saveCustomer(theCustomer);
		
		return theCustomer;
	}




}
