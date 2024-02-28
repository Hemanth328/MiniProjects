package com.irg.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.irg.dao.CitizenPlans;
import com.irg.mailing.EmailSender;
import com.irg.mailing.ExcelGenerator;
import com.irg.mailing.PdfGenerator;
import com.irg.repo.CitizenPlanRepo;
import com.irg.request.SearchRequest;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements IReportService{

	@Autowired
	private CitizenPlanRepo cprepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailSender mailsender;
	
	@Override
	public List<String> getPlanNames() {
		
//		List<String> list = cprepo.getPlanNames();
//		return list;
		
		return cprepo.getPlanNames();
	}
	
	@Override
	public List<String> getPlanStatuses() {
		
		/*List<String> list = cprepo.getPlanStaus();
		
		return list;*/
		
		return cprepo.getPlanStatus();
	}
	
	@Override
	public List<CitizenPlans> search(SearchRequest request) {
		/*
		List<CitizenPlans> list = cprepo.findAll();
		list.forEach(System.out::println);
		
		*/
		
		/*
		return list;
		*/
		
		CitizenPlans entity = new CitizenPlans();
//		BeanUtils.copyProperties(request, entity);
		
		if(null != request.getPlanName() && !"".equals(request.getPlanName()))
			entity.setPlanName(request.getPlanName());
		
		if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus()))
			entity.setPlanStatus(request.getPlanStatus());
		
		if(null != request.getGender() && !"".equals(request.getGender()))
			entity.setGender(request.getGender());
		
		if(null != request.getStartDate() && !"".equals(request.getStartDate()))
			entity.setPlanStartDate(request.getStartDate());
		
		if(null != request.getEndDate() && !"".equals(request.getEndDate()))
			entity.setPlanEndDate(request.getEndDate());
		
		
		return cprepo.findAll(Example.of(entity));
	}
	
	@Override
	public boolean exportExcel(HttpServletResponse response)  throws Exception {
		
		File file = new File("Citizen-Plans.xlsx");
		
		List<CitizenPlans> records = cprepo.findAll();
		
		excelGenerator.excelGenerator(response, records, file);
		
		String subject = "Testing Mail Sending Application";
		String body = "<h1>Hey you have an attachment !<br> Check your attachment....!</h1>";
		String to = "reddy.hemanthkumar99@gmail.com";
		
		mailsender.sendmail(subject, body, to, file);
		
		file.delete();
		
		return true;
	}
	
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		File file = new File("Citizen-Plans.pdf");
		
		List<CitizenPlans> records = cprepo.findAll();		
		
		
		pdfGenerator.pdfGenerator(response, records, file);		

		String subject = "Testing Mail Sending Application";
		String body = "<h1>Hey you have a Pdf attachment !<br> Check your attachment....!</h1>";
		String to = "sirip93@gmail.com";
		
		mailsender.sendmail(subject, body, to, file);
		
		file.delete();
		
		return true;
	}
	
}
