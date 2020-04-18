package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public List<Customer> findAll(){
		return customerRepo.findAll();
	}
	
	public void save(Customer customer) {
		customerRepo.save(customer);
    }
     
    public Customer get(Integer Customer_ID) {
        return customerRepo.findById(Customer_ID).get();
    }
     
    public void delete(Integer Customer_ID) {
    	customerRepo.deleteById(Customer_ID);
    }

}
