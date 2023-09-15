package com.irg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irg.service.ReportServiceImpl;

@Controller
public class ReportController {
	
	@Autowired
	private ReportServiceImpl rservice;
	
	@GetMapping("/")
	public  String getIndexPage() {
		
		return "index";
	}

}
