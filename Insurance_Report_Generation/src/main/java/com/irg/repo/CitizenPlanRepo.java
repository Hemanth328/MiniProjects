package com.irg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irg.dao.CitizenPlans;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlans, Integer> {
	
	@Query("select distinct(planName) from citizenPlans")
	public List<String> getPlanNames();
	
	@Query("selecr distinct(planStatus) from citizenPlans")
	public List<String> getPlanStaus();
	
}
