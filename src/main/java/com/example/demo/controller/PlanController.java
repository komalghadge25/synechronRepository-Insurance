package com.example.demo.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Plan;
import com.example.demo.exception.NoSuchRecordException;
import com.example.demo.repository.PlanRepository;
//import com.example.demo.service.PlanService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PlanController{
	
	/*
	 * @Autowired private PlanService planService;
	 */
	
	@Autowired
	private PlanRepository planRepo;
	
	
	
	@GetMapping(path="/plans")
	public List<Plan> getPlans(){
		return planRepo.findAll();
	}
	
	@GetMapping(path = "/plans/{plan_ID}")
	public Plan getPlanById(@PathVariable int plan_ID) {
		
		 return planRepo.findById(plan_ID).orElseThrow(()-> new NoSuchRecordException("NO SUCH ELEMENT FOUND!!"));
	
	}
	
	@PostMapping(path="/plans")
	public Plan addPlan(@Valid @RequestBody Plan plan) {
		return planRepo.save(plan);
	}
	
	@PutMapping(path = "/plans/{plan_ID}")
	public Plan updatePlan(@RequestBody Plan plan, @PathVariable int plan_ID){
		planRepo.findById(plan_ID);
		return planRepo.save(plan);
	}
	
	@DeleteMapping(path = "/plans/{plan_ID}")
	public void deletePlan(@PathVariable int plan_ID) {
		planRepo.deleteById(plan_ID);
	}
	

	
}
