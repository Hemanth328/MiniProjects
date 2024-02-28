package com.irg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irg.dao.CitizenPlans;

public interface CitizenPlanRepo extends JpaRepository<CitizenPlans, Integer> {
	
	@Query("select distinct(planName) from CitizenPlans")
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus) from CitizenPlans")
	public List<String> getPlanStatus();
	
}
