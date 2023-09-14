package com.irg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irg.repo.CitizenPlanRepo;

@Service
public class ReportServiceImpl implements IReportService{

	@Autowired
	private CitizenPlanRepo cprepo;
	
	@Override
	public List<String> getPlansName() {
		
		List<String> list = cprepo.getPlanNames();
		return list;
	}
	
	@Override
	public List<String> getPlansStatus() {
		
		List<String> list = cprepo.getPlanStaus();
		
		return list;
	}
}
