package com.irg.mailing;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.irg.dao.CitizenPlans;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	public void excelGenerator(HttpServletResponse response, List<CitizenPlans> records, File file) throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
//		Workbook workbook = new HSSFWorkbook();
		Sheet sheet =  workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		
		headerRow.createCell(0).setCellValue("Citizen-ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Benefit Amount");
		headerRow.createCell(6).setCellValue("Plan Start Date");
		headerRow.createCell(7).setCellValue("Plan End Date");
		
		int rowIndex = 1;
		
		for(CitizenPlans plan: records) {
			
			Row dataRow = sheet.createRow(rowIndex);
			
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender()+"");
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			
			if(null!= plan.getBenefitAmount())
				dataRow.createCell(5).setCellValue(plan.getBenefitAmount());
			else
				dataRow.createCell(5).setCellValue("N/A");
			
			
			if(null!= plan.getPlanStartDate())
				dataRow.createCell(6).setCellValue(plan.getPlanStartDate()+"");
			else
				dataRow.createCell(6).setCellValue("N/A");
			
			if(null!= plan.getPlanEndDate())
				dataRow.createCell(7).setCellValue(plan.getPlanEndDate()+"");
			else
				dataRow.createCell(7).setCellValue("N/A");
			
			
			rowIndex++;
		}
		
		// This logic is implemented to save the file
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
//		workbook.close();
		
		// This logic is implemented to download the file
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
	}

}
