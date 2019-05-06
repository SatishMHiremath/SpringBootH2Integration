package com.example.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

//@Repository
//public interface CustomerRepository extends CrudRepository<Customer, Long> {
//	List<Customer> findByAge(Integer age);
//
//}


@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {  
	
}  
