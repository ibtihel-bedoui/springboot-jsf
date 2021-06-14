package tn.dari.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.dari.entities.Bank;
import tn.dari.repository.BankRep;
import tn.dari.repository.UserRep;

@Service
@Transactional
public class BankService implements IBankService {
	@Autowired
	BankRep banks ;
	UserRep  users;
	

	@Override
	public List<Bank> getAllBank() {
	return (List<Bank>) banks.findAll();
	}
	@Override
	public Bank getById(long id) {
		
		return banks.findById(id).get();
	}
	@Override
	public void deleteBankById(Long BankId) {
		Bank b =banks.findById(BankId).orElse(null);
		banks.delete(b);
		
	}
	
	@Override
	public void ajouterBanque(Bank b ) {

		banks.save(b);
		
	}

	@Override
	public Bank updateBank(Bank b){
		return banks.save(b);
	}
	
	@Override
	public long getNombreBankJPQL(String address) {
		return banks.getNombreBankJPQL(address);
	}
	
/*******************Pdf**********************/
	
	@Override
	public boolean createPdf(List<Bank> agencies, ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		
		Document document=new Document(PageSize.A4, 15, 15, 45, 30);
		try{
			
	    String filPath= context.getRealPath("/resources/reports");
	    File file =new File(filPath);
	    boolean exists= new File(filPath).exists();
	    if(!exists){
	    	new File(filPath).mkdirs();
	    }
	    
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"Banks"+".pdf"));
	    document.open();
	    
	    Font mainFont = FontFactory.getFont("Arial",10, BaseColor.BLACK);
	    
	    Paragraph paragraph= new Paragraph("All Banks", mainFont);
	    paragraph.setAlignment(Element.ALIGN_CENTER);
	    paragraph.setIndentationLeft(50);
	    paragraph.setIndentationRight(50);
	    paragraph.setSpacingAfter(10);
	    document.add(paragraph);
	    
	    
	    PdfPTable table = new PdfPTable(6);
	    table.setWidthPercentage(100);
	    table.setSpacingBefore(10f);
	    table.setSpacingAfter(10);
	    
	    Font tableHeader = FontFactory.getFont("Arial",10, BaseColor.BLACK);
	    Font tableBody = FontFactory.getFont("Arial",9, BaseColor.BLACK);
	    
	    float[] columnWidths = {2f, 2f, 2f, 2f, 2f, 2f};
	    table.setWidths(columnWidths);
	    
	    PdfPCell id =new PdfPCell(new Paragraph("Bank Num", tableHeader));
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
	    
	    PdfPCell phone =new PdfPCell(new Paragraph("Phone", tableHeader));
	    phone.setBorderColor(BaseColor.BLACK);
	    phone.setPaddingLeft(10);
	    phone.setHorizontalAlignment(Element.ALIGN_CENTER);
	    phone.setVerticalAlignment(Element.ALIGN_CENTER);
	    phone.setBackgroundColor(BaseColor.GRAY);
	    phone.setExtraParagraphSpace(5);
	    table.addCell(phone);
	    
	    
	    PdfPCell email =new PdfPCell(new Paragraph("Email", tableHeader));
	    email.setBorderColor(BaseColor.BLACK);
	    email.setPaddingLeft(10);
	    email.setHorizontalAlignment(Element.ALIGN_CENTER);
	    email.setVerticalAlignment(Element.ALIGN_CENTER);
	    email.setBackgroundColor(BaseColor.GRAY);
	    email.setExtraParagraphSpace(5);
	    table.addCell(email);
	    
	     for (Bank bank: agencies){
	    	
	        PdfPCell idValue =new PdfPCell(new Paragraph(bank.getId()+"", tableBody));
	    	idValue.setBorderColor(BaseColor.BLACK);
	    	idValue.setPaddingLeft(10);
	    	idValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	idValue.setVerticalAlignment(Element.ALIGN_CENTER);
	    	idValue.setBackgroundColor(BaseColor.WHITE);
	    	idValue.setExtraParagraphSpace(5);
	 	    table.addCell(idValue);
	 	    
	 	   PdfPCell bankNameValue =new PdfPCell(new Paragraph(bank.getName(), tableBody));
	 	   bankNameValue.setBorderColor(BaseColor.BLACK);
	 	   bankNameValue.setPaddingLeft(10);
	 	   bankNameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	   bankNameValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	   bankNameValue.setBackgroundColor(BaseColor.WHITE);
	 	   bankNameValue.setExtraParagraphSpace(5);
	 	   table.addCell(bankNameValue);
	 
	 	   
	 	  PdfPCell addressValue =new PdfPCell(new Paragraph(bank.getAddress(), tableBody));
	 	 addressValue.setBorderColor(BaseColor.BLACK);
	 	addressValue.setPaddingLeft(10);
	 	addressValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	addressValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	addressValue.setBackgroundColor(BaseColor.WHITE);
	 	addressValue.setExtraParagraphSpace(5);
	 	   table.addCell(addressValue);
	 	   
	 	  PdfPCell phoneValue =new PdfPCell(new Paragraph(bank.getPhone()+"", tableBody));
	 	 phoneValue.setBorderColor(BaseColor.BLACK);
	 	phoneValue.setPaddingLeft(10);
	 	phoneValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	phoneValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	phoneValue.setBackgroundColor(BaseColor.WHITE);
	 	phoneValue.setExtraParagraphSpace(5);
	 	   table.addCell(phoneValue);
	 	   
	 	  PdfPCell emailValue =new PdfPCell(new Paragraph(bank.getEmail(), tableBody));
	 	  emailValue.setBorderColor(BaseColor.BLACK);
	 	  emailValue.setPaddingLeft(10);
	 	  emailValue.setHorizontalAlignment(Element.ALIGN_CENTER);
	 	  emailValue.setVerticalAlignment(Element.ALIGN_CENTER);
	 	  emailValue.setBackgroundColor(BaseColor.WHITE);
	 	  emailValue.setExtraParagraphSpace(5);
	 	   table.addCell(emailValue);
	    	 
	     }
	     
	     document.add(table);
	     document.close();
	     writer.close();
	     return true;
	
		}catch (Exception e) {
			return false;
		}
		
		
	}
	

	
	
	
	
	
}
	


	



