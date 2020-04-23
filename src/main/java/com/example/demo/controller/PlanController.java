package com.example.demo.controller;

import java.util.List;
//import javax.persistence.ElementCollection;
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
import com.example.demo.service.PlanService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PlanController{
	
	
	  @Autowired private PlanService planService;
	 
	
	
	@GetMapping(path="/plans")
	public List<Plan> getPlans(){
		return planService.getAllPlans();
	}
	
	@GetMapping(path = "/plans/{plan_ID}")
	public Plan getPlanById(@PathVariable int plan_ID) {
		return planService.getPlanById(plan_ID);
	}
	
	@PostMapping(path="/plans")
	public void addPlan(@Valid @RequestBody Plan plan) {
		planService.savePlan(plan);
	}
	
	
	@PutMapping(path = "/plans/{plan_ID}")
	public void updatePlan(@RequestBody Plan plan, @PathVariable int plan_ID){
		planService.getPlanById(plan_ID);
		planService.savePlan(plan);
	}
	
	@DeleteMapping(path = "/plans/{plan_ID}")
	public void deletePlan(@PathVariable int plan_ID) {
		planService.deletePlanById(plan_ID);
	}
	

	
}
