package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Customer_ID;
	
	private String First_Name;
	
	private String Middle_name;
	
	private String Last_Name;
	
	private String Gender;
	
	private Date Date_of_Birth;
	
	private String Medical_Conditions;
	
	private String Comment;
	
	private String Other_Details;

}
