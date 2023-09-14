package com.irg.dao;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name= "CITIZENS_PLANS_INFO")
public class CitizenPlans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	
	private String citizenName;
	
	private Character gender;
	
	private String planName;
	
	private String planStatus;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	private Double benefitAmount;
	
	private String DenialReason;
	
	private LocalDate terminatedDate;
	
	private String terminationReason;

}

