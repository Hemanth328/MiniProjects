package com.irg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irg.dao.CitizenPlans;
import com.irg.repo.CitizenPlanRepo;
import com.irg.request.SearchRequest;

@Service
public class ReportServiceImpl implements IReportService{

	@Autowired
	private CitizenPlanRepo cprepo;
	
	@Override
	public List<String> getPlanNames() {
		
		List<String> list = cprepo.getPlanNames();
		return list;
	}
	
	@Override
	public List<String> getPlanStatuses() {
		
		List<String> list = cprepo.getPlanStaus();
		
		return list;
	}
	
	@Override
	public List<CitizenPlans> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
