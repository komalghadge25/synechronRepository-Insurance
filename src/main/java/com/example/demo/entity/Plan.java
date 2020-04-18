package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
@Entity
@Table(name="plan")

public class Plan implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int plan_ID;
	
	@Column(name="insurance_provider")
	@NotEmpty(message = "insuranceProvider must not be empty")
	private String insuranceProvider;
	
	@Column(name="cover")
	@NotNull(message="Premium must not be null")
	private double cover;
	
	@Column(name="features_covered")
	@NotEmpty(message = "featuresCovered must not be empty")
	private String featuresCovered;
	
	@Column(name="features_not_covered")
	@NotEmpty(message = "featuresNotCovered must not be empty")
	private String featuresNotCovered;
	
	@Column(name="premium")
	@NotNull(message="Premium must not be null")
	private double premium;
	
	@Column(name="plan_type")
	@NotEmpty(message = "planType must not be empty")
	private String planType;
	
	@Column(name="claim_settlement")
	@NotEmpty(message = "claimSettlement must not be empty")
	private String claimSettlement;
	
	
}
