package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import lombok.Setter;

@RestController
@Setter
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(path="/customers")
	public List<Customer> list() {
		
	    return service.findAll();
	}
	
	@GetMapping(path="/customers/{Customer_ID}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int Customer_ID){
		
		try {
	        Customer customer = service.get(Customer_ID);
	        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	        
	    } catch (NoSuchElementException e) {
	    	System.out.println("NO such Element Found!!"+e);
	    	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	    }   
		
	}
	
	@PostMapping(path="/customers")
	public void add(@RequestBody Customer customer) {
		service.save(customer);
	}
	
	@PutMapping("/customers/{Customer_ID}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable int Customer_ID) {
	    try {
	        service.get(Customer_ID);
	        service.save(customer);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/customers/{Customer_ID}")
	public void deleteCustomer(@PathVariable int Customer_ID) {
		service.delete(Customer_ID);
	}

}
