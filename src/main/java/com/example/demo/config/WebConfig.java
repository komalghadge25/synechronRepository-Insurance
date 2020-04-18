package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Plan;

@Configuration
public class WebConfig {
	
	@Bean
	public Customer customer() {
		return new Customer();
	}
	
	@Bean
	public Plan plan() {
		return new Plan();
	}
}
