package com.irg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.repo.service.ReportServiceImpl;

@RestController
public class ReportController {
	
	@Autowired
	private ReportServiceImpl rservice;

}
