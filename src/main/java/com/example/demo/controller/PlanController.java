package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Plan;
import com.example.demo.service.PlanService;


@RestController
@CrossOrigin(origins = "*")
public class PlanController{
	
	@Autowired
	private PlanService planService;
	
	
	@ExceptionHandler(value = NumberFormatException.class)  
	 public String nfeHandler(NumberFormatException  e){  
	     return "[NUMBER FORMAT EXCEPTION] Invalid Entry ==>  "+e.getMessage();  
	 }  
	
	@ExceptionHandler(value = NoSuchElementException .class)  
	 public String nseHandler(NoSuchElementException  e){  
	     return "[NO SUCH ELEMENT EXCEPTION] Invalid Entry ==>  "+e.getMessage();  
	 }  
	
	
	@GetMapping(path="/plans")
	public List<Plan> getPlans(){
		return planService.getAllPlans();
	}
	
	
	@GetMapping(path = "/plans/{plan_ID}")
	public ResponseEntity<Plan> getPlanById(@PathVariable int plan_ID) {
		Plan plan=planService.getPlanById(plan_ID);
		 return new ResponseEntity<Plan>(plan,HttpStatus.OK);
		}
	
	
	@PostMapping(path="/plans")
	public ResponseEntity<Plan> addPlan(@Valid @RequestBody Plan plan) {
				planService.savePlan(plan);
				return new ResponseEntity<Plan>(plan,HttpStatus.OK);
		}
	
	
	@PutMapping(path = "/plans/{plan_ID}")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan, @PathVariable int plan_ID){
		
		
				planService.getPlanById(plan_ID);
				planService.savePlan(plan);
				return new ResponseEntity<Plan>(plan,HttpStatus.OK);
			
		}
	
	@DeleteMapping(path = "/plans/{plan_ID}")
	public ResponseEntity<Plan> deletePlan(@RequestBody Plan plan,@PathVariable int plan_ID) {
		
				planService.deletePlanById(plan_ID);
				return new ResponseEntity<Plan>(plan,HttpStatus.OK);
		}
	

	
}