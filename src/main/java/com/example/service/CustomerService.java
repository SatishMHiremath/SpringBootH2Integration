package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;

//	public List<Customer> findByAge(int age) {
//		List<Customer> customers = this.repository.findByAge(age);
//		return customers;
//	}
//	
//	public Customer getCustomerById(long id) {
//		return this.repository.findById(id).get();
//	}
//	
//	public List<Customer> getAllCustomers() {
//		System.out.println("Get all Customers...");
//
//		List<Customer> customers = new ArrayList<>();
//		this.repository.findAll().forEach(customers::add);
//
//		return customers;
//	}
//	
//	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") long id) {
//		System.out.println("Delete Customer with ID = " + id + "...");
//		this.repository.deleteById(id);
//		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
//	}
//
//	public ResponseEntity<String> deleteAllCustomers() {
//		System.out.println("Delete All Customers...");
//		this.repository.deleteAll();
//		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
//	}
//	
//	public Customer postCustomer(@RequestBody Customer customer) {
//		Customer _customer = this.repository.save(new Customer(customer.getName(), customer.getAge()));
//		return _customer;
//	}
//
//	@PutMapping("/customers/{id}")
//	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
//		System.out.println("Update Customer with ID = " + id + "...");
//
//		Optional<Customer> customerData = this.repository.findById(id);
//
//		if (customerData.isPresent()) {
//			Customer _customer = customerData.get();
//			_customer.setName(customer.getName());
//			_customer.setAge(customer.getAge());
//			_customer.setActive(customer.getActive());
//			return new ResponseEntity<>(this.repository.save(_customer), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	
    public List<Customer> getAllCustomers() {
        List<Customer> persons = new ArrayList<Customer>();
        repository.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Customer getCustomerById(String id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Customer person) {
    	repository.save(person);
    }

    public void deleteCustomerById(String id) {
    	repository.deleteById(id);
    }

	
}
