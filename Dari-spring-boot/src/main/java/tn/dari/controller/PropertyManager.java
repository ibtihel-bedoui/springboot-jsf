package tn.dari.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.springframework.beans.factory.annotation.Autowired;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import tn.dari.entities.Bank;
import tn.dari.repository.BankRep;

@Named(value = "manager")
@ViewScoped
public class PropertyManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String address;
	private float interest;
	private String email;
	private int phone;
	private String website;

	@Autowired
	BankRep bankRepository;
	
 public void postProcessPDF(Object document) throws com.itextpdf.text.DocumentException {
		 
		 List<Bank> banks=(List<Bank>) bankRepository.findAll();
		
		    
		    Font mainFont = FontFactory.getFont("Arial",10, BaseColor.BLACK);
		    
		    Paragraph paragraph= new Paragraph("All Banks", mainFont);
		    paragraph.setAlignment(Element.ALIGN_CENTER);
		    paragraph.setIndentationLeft(50);
		    paragraph.setIndentationRight(50);
		    paragraph.setSpacingAfter(10);
		  
		    
		    
		    PdfPTable table = new PdfPTable(6);
		    table.setWidthPercentage(100);
		    table.setSpacingBefore(10f);
		    table.setSpacingAfter(10);
		    
		    Font tableHeader = FontFactory.getFont("Arial",10, BaseColor.BLACK);
		    Font tableBody = FontFactory.getFont("Arial",9, BaseColor.BLACK);
		    
		    float[] columnWidths = {2f, 2f, 2f, 2f, 2f, 2f};
		    table.setWidths(columnWidths);
		    
		    PdfPCell id =new PdfPCell(new Paragraph("Num", tableHeader));
		    id.setBorderColor(BaseColor.BLACK);
		    id.setPaddingLeft(10);
		    id.setHorizontalAlignment(Element.ALIGN_CENTER);
		    id.setVerticalAlignment(Element.ALIGN_CENTER);
		    id.setBackgroundColor(BaseColor.GRAY);
		    id.setExtraParagraphSpace(5);
		    table.addCell(id);
		    
		    PdfPCell name =new PdfPCell(new Paragraph("Bank Name", tableHeader));
		    name.setBorderColor(BaseColor.BLACK);
		    name.setPaddingLeft(10);
		    name.setHorizontalAlignment(Element.ALIGN_CENTER);
		    name.setVerticalAlignment(Element.ALIGN_CENTER);
		    name.setBackgroundColor(BaseColor.GRAY);
		    name.setExtraParagraphSpace(5);
		    table.addCell(name);
		
		    
		    PdfPCell address =new PdfPCell(new Paragraph("Address", tableHeader));
		    address.setBorderColor(BaseColor.BLACK);
		    address.setPaddingLeft(10);
		    address.setHorizontalAlignment(Element.ALIGN_CENTER);
		    address.setVerticalAlignment(Element.ALIGN_CENTER);
		    address.setBackgroundColor(BaseColor.GRAY);
		    address.setExtraParagraphSpace(5);
		    table.addCell(address);
		    
	
		    PdfPCell email =new PdfPCell(new Paragraph("Email", tableHeader));
		    email.setBorderColor(BaseColor.BLACK);
		    email.setPaddingLeft(10);
		    email.setHorizontalAlignment(Element.ALIGN_CENTER);
		    email.setVerticalAlignment(Element.ALIGN_CENTER);
		    email.setBackgroundColor(BaseColor.GRAY);
		    email.setExtraParagraphSpace(5);
		    table.addCell(email);
		    
		    PdfPCell phone =new PdfPCell(new Paragraph("Phone", tableHeader));
		    phone.setBorderColor(BaseColor.BLACK);
		    phone.setPaddingLeft(10);
		    phone.setHorizontalAlignment(Element.ALIGN_CENTER);
		    phone.setVerticalAlignment(Element.ALIGN_CENTER);
		    phone.setBackgroundColor(BaseColor.GRAY);
		    phone.setExtraParagraphSpace(5);
		    table.addCell(phone);
		    
		    PdfPCell website =new PdfPCell(new Paragraph("Website", tableHeader));
		    website.setBorderColor(BaseColor.BLACK);
		    website.setPaddingLeft(10);
		    website.setHorizontalAlignment(Element.ALIGN_CENTER);
		    website.setVerticalAlignment(Element.ALIGN_CENTER);
		    website.setBackgroundColor(BaseColor.GRAY);
		    website.setExtraParagraphSpace(5);
		    table.addCell(website);
		    
		    
		     for (Bank bank: banks){
		    	
		        PdfPCell idValue =new PdfPCell(new Paragraph(bank.getId()+"", tableBody));
		    	idValue.setBorderColor(BaseColor.BLACK);
		    	idValue.setPaddingLeft(10);
		    	idValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	idValue.setVerticalAlignment(Element.ALIGN_CENTER);
		    	idValue.setBackgroundColor(BaseColor.WHITE);
		    	idValue.setExtraParagraphSpace(5);
		 	    table.addCell(idValue);
		 	    
		 	   PdfPCell nameValue =new PdfPCell(new Paragraph(bank.getName(), tableBody));
		 	  nameValue.setBorderColor(BaseColor.BLACK);
		 	 nameValue.setPaddingLeft(10);
		 	nameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	nameValue.setVerticalAlignment(Element.ALIGN_CENTER);
		 	nameValue.setBackgroundColor(BaseColor.WHITE);
		 	nameValue.setExtraParagraphSpace(5);
		 	   table.addCell(nameValue);
	
		 	   
		 	  PdfPCell addressValue =new PdfPCell(new Paragraph(bank.getAddress(), tableBody));
		 	 addressValue.setBorderColor(BaseColor.BLACK);
		 	addressValue.setPaddingLeft(10);
		 	addressValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	addressValue.setVerticalAlignment(Element.ALIGN_CENTER);
		 	addressValue.setBackgroundColor(BaseColor.WHITE);
		 	addressValue.setExtraParagraphSpace(5);
		 	   table.addCell(addressValue);
		 	 
		 	   
		 	  PdfPCell emailValue =new PdfPCell(new Paragraph(bank.getEmail(), tableBody));
		 	  emailValue.setBorderColor(BaseColor.BLACK);
		 	  emailValue.setPaddingLeft(10);
		 	  emailValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	  emailValue.setVerticalAlignment(Element.ALIGN_CENTER);
		 	  emailValue.setBackgroundColor(BaseColor.WHITE);
		 	  emailValue.setExtraParagraphSpace(5);
		 	   table.addCell(emailValue);
		    	 
		 	  PdfPCell phoneValue =new PdfPCell(new Paragraph(bank.getPhone()+"", tableBody));
		 	 phoneValue.setBorderColor(BaseColor.BLACK);
		 	phoneValue.setPaddingLeft(10);
		 	phoneValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	phoneValue.setVerticalAlignment(Element.ALIGN_CENTER);
		 	phoneValue.setBackgroundColor(BaseColor.WHITE);
		 	phoneValue.setExtraParagraphSpace(5);
		 	   table.addCell(phoneValue);
		 	   
		 	  PdfPCell websiteValue =new PdfPCell(new Paragraph(bank.getWebsite()+"", tableBody));
		 	 websiteValue.setBorderColor(BaseColor.BLACK);
		 	websiteValue.setPaddingLeft(10);
		 	 websiteValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		 	websiteValue.setVerticalAlignment(Element.ALIGN_CENTER);
		 	websiteValue.setBackgroundColor(BaseColor.WHITE);
		 	websiteValue.setExtraParagraphSpace(5);
		 	   table.addCell(websiteValue);
		     }
 
		 
	 }
 
 public void postProcessXLS(Object document) {
	 
	 List<Bank> banks=(List<Bank>) bankRepository.findAll();
	 
	 HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet workSheet = workbook.createSheet("banks");
		workSheet.setDefaultColumnWidth(30);
		HSSFCellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		HSSFRow headerRow = workSheet.createRow(0);
		
		HSSFCell id = headerRow.createCell(0);
		id.setCellValue("Num");
		id.setCellStyle(headerCellStyle);
		
		HSSFCell name = headerRow.createCell(1);
		name.setCellValue("Bank Name");
		name.setCellStyle(headerCellStyle);

		
		HSSFCell address = headerRow.createCell(2);
		address.setCellValue("Address");
		address.setCellStyle(headerCellStyle);
		
		HSSFCell interest = headerRow.createCell(3);
		interest.setCellValue("Interest");
		interest.setCellStyle(headerCellStyle);

		
		HSSFCell email = headerRow.createCell(4);
		email.setCellValue("Email");
		email.setCellStyle(headerCellStyle);
		
		HSSFCell phone = headerRow.createCell(5);
		phone.setCellValue("Phone");
		phone.setCellStyle(headerCellStyle);
		
		
		HSSFCell website = headerRow.createCell(6);
		website.setCellValue("Website");
		website.setCellStyle(headerCellStyle);
		int i=1;
		for(Bank bank : banks){
			
			HSSFRow bodyRow =workSheet.createRow(i);
			HSSFCellStyle bodyCelleStyle = workbook.createCellStyle();
			bodyCelleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			
			HSSFCell idValue = bodyRow.createCell(0);
			idValue.setCellValue(bank.getId());
			idValue.setCellStyle(bodyCelleStyle);
			
			HSSFCell nameValue = bodyRow.createCell(1);
			nameValue.setCellValue(bank.getName());
			nameValue.setCellStyle(bodyCelleStyle);
			
			HSSFCell addressValue = bodyRow.createCell(2);
			addressValue.setCellValue(bank.getAddress());
			addressValue.setCellStyle(bodyCelleStyle);
			
			HSSFCell interestValue = bodyRow.createCell(3);
			interestValue.setCellValue(bank.getInterest());
			interestValue.setCellStyle(bodyCelleStyle);
			
	
			
			HSSFCell emailValue = bodyRow.createCell(4);
			emailValue.setCellValue(bank.getEmail());
			emailValue.setCellStyle(bodyCelleStyle);
			
			HSSFCell phoneValue = bodyRow.createCell(5);
			phoneValue.setCellValue(bank.getPhone());
			phoneValue.setCellStyle(bodyCelleStyle);
			
			HSSFCell websiteValue = bodyRow.createCell(6);
			websiteValue.setCellValue(bank.getWebsite());
			websiteValue.setCellStyle(bodyCelleStyle);
			i++;
			 
		}
 }
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public float getInterest() {
	return interest;
}

public void setInterest(float interest) {
	this.interest = interest;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

public BankRep getBankRepository() {
	return bankRepository;
}

public void setBankRepository(BankRep bankRepository) {
	this.bankRepository = bankRepository;
}
 
 
}
