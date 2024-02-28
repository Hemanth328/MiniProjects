package com.irg.mailing;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.irg.dao.CitizenPlans;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void pdfGenerator(HttpServletResponse response, List<CitizenPlans> records, File file) throws Exception {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document , new FileOutputStream(file));
		
		document.open();

		Paragraph paragragh = new Paragraph("Hey This is the new PDF File ");

		paragragh.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragragh);

		PdfPTable table = new PdfPTable(8);

		table.setWidthPercentage(100f);
		table.setSpacingAfter(5f);
		table.setSpacingBefore(5f);

		table.addCell("CitizenId");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan status");
		table.addCell("Benefit Amount");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");

		for (CitizenPlans plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(String.valueOf(plan.getGender()));
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());

			if (null != plan.getBenefitAmount())
				table.addCell(String.valueOf(plan.getBenefitAmount()));
			else
				table.addCell("N/A");

			if (null != plan.getPlanStartDate())
				table.addCell(String.valueOf(plan.getPlanStartDate()));
			else
				table.addCell("N/A");

			if (null != plan.getPlanEndDate())
				table.addCell(String.valueOf(plan.getPlanEndDate()));
			else
				table.addCell("N/A");
		}

		document.add(table);


		document.close();
	}
}
