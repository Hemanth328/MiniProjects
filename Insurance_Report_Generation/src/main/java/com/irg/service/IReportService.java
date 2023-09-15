package com.irg.service;

import java.util.List;

import com.irg.dao.CitizenPlans;
import com.irg.request.SearchRequest;

public interface IReportService { 
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlans> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();

}
