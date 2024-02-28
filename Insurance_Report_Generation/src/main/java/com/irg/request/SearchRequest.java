package com.irg.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
	
	private String planName;
	
	private String planStatus;
	
	private Character gender;
	
	private LocalDate startDate;
	
	private LocalDate endDate;	
	
}
