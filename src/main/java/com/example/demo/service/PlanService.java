package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Plan;
import com.example.demo.repository.PlanRepository;

@Service
@Transactional
public class PlanService {
	
	@Autowired
	private PlanRepository planRepo;
	
	public List<Plan> getAllPlans(){
		return planRepo.findAll();
	}
	
	public void savePlan(Plan plan) {
		planRepo.save(plan);
	}
	
	public Plan getPlanById(int plan_ID) {
		return planRepo.findById(plan_ID).get();
	}
	
	public void deletePlanById(int plan_ID) {
		planRepo.deleteById(plan_ID);
		
	}
	
	

}
