package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;


//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api")
//public class CustomerController {

//	@Autowired
//	CustomerService customerService;
//
//	@GetMapping(value = "customers/age/{age}")
//	public List<Customer> findByAge(@PathVariable int age) {
//		List<Customer> customers = this.customerService.findByAge(age);
//		return customers;
//	}
//	
//	@GetMapping("/customers/{id}")
//	private Customer getCustomer(@PathVariable("id") long id) {
//		return customerService.getCustomerById(id);
//	}
//	
//	@GetMapping("/customers")
//	private List<Customer> getAllCustomers() {
//		return customerService.getAllCustomers();
//	}


//	@DeleteMapping("/customers/{id}")
//	private ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
//		return new ResponseEntity<Customer>(customerService.deleteCustomerById(id), HttpStatus.OK);
//	}
//
//	@DeleteMapping("/customers/delete")
//	private ResponseEntity<String> deleteAllCustomers() {
//		customerService.deleteAllCustomers();
//		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
//	}
//
//	
//	@PostMapping(value = "/customers/create")
//	public Customer postCustomer(@RequestBody Customer customer) {
//		customerService.postCustomer(customer);
//		return customer;	
//	}

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService custService;


	@GetMapping("/customers")
	private List<Customer> getAllCustomers() {
		return custService.getAllCustomers();
	}

	@GetMapping("/customers/{id}")
	private Customer getCustomer(@PathVariable("id") String id) {
		return custService.getCustomerById(id);
	}

	@DeleteMapping("/customers/{id}")
	private void deleteCustomer(@PathVariable("id") String id) {
		custService.deleteCustomerById(id);
	}

	@PostMapping("/customers/create")
	private void saveCustomer(@RequestBody Customer person) {
		custService.saveOrUpdate(person);
	}
}
