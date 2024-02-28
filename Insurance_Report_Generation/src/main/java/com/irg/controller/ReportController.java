package com.irg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irg.dao.CitizenPlans;
import com.irg.request.SearchRequest;
import com.irg.service.IReportService;
import com.irg.service.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private IReportService repService;

	private void init(Model model) {
//		model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", repService.getPlanNames());
		model.addAttribute("status", repService.getPlanStatuses());
	}

	/**
	 * This method is used to load the index page
	 * 
	 * @param model
	 * @return String
	 */

	@GetMapping("/")
	public String getIndexPage(Model model) { // Model class is used to send the data from controller to UI

		SearchRequest search = new SearchRequest();

		model.addAttribute("search", search);
		init(model);

		return "index";
	}

	/**
	 * This method is implemented to handle request
	 * 
	 * @param srequest
	 * @param model
	 * @return
	 */

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest srequest, Model model) {

//		System.out.println(srequest);

		List<CitizenPlans> plans = repService.search(srequest);

		model.addAttribute("plans", plans);

		init(model);

		return "index";

	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream"); // we are setting content type in which format we are
																// sending the data
		// for excel its "octet-stream" and for pdf its "pdf"

		response.setHeader("Content-Disposition", "attachment; filename=citizenplans.xls");

		repService.exportExcel(response);

		
	}

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {

		response.setContentType("application/pdf");

		response.setHeader("Content-Disposition", "attachment; filename=citizenplans.pdf");

		repService.exportPdf(response);

		
	}

}
