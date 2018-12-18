package gr.hua.dit.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springmvc1.dao.CustomerDAO;
import gr.hua.dit.springmvc1.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from dao
		List<Customer> customers = customerDAO.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
	
	@GetMapping("/{id}")
	public String getCustomer(Model model, @PathVariable("id") int id) {
		// get the customer
		Customer customer = customerDAO.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/addCustomer")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		// add page title
		model.addAttribute("pageTitle", "Add a Customer");
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveStudent(@ModelAttribute("student") Customer customer) {
		// save the student using the service
		customerDAO.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}

}
