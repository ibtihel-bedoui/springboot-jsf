package tn.dari.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.dari.entities.Bank;
import tn.dari.service.IBankService;

@Scope(value = "session")
@Controller(value = "bankController")
@ELBeanName(value = "bankController")
@Join(path = "/", to = "/login.jsf")
public class BankController {

	@Autowired
	IBankService iBankService;
	
	
	public void addBank() {
		iBankService.ajouterBanque(new Bank(id, name, address, interest, email, phone, website));
		}

		public List<Bank> getBanks() {
		banks = iBankService.getAllBank();
		return banks;
		}
	
		public void deleteBank(Long BankId) {
			iBankService.deleteBankById(BankId);;
		}
		
		
	
	
		// ----------------------------------JSF--------------------------------------------------------
	private Long id;
	private String name;
	private String address;
	private float interest;
	private String email;
	private int phone;
	private String website;
	private Bank bank;
	private List<Bank> banks;
	private Long bankIdToBeUpdated;

	public Long getBankIdToBeUpdated() {
		return bankIdToBeUpdated;
	}

	public void setBankIdToBeUpdated(Long bankIdToBeUpdated) {
		this.bankIdToBeUpdated = bankIdToBeUpdated;
	}

	public IBankService getiBankService() {
		return iBankService;
	}

	public void setiBankService(IBankService iBankService) {
		this.iBankService = iBankService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}
	
	public void displayBank(Bank bk) {
		this.setBankIdToBeUpdated(bk.getId());
		this.setName(bk.getName());
		this.setAddress(bk.getAddress());
		this.setInterest(bk.getInterest());
		this.setEmail(bk.getEmail());
		this.setPhone(bk.getPhone());
		this.setWebsite(bk.getWebsite());
		
	}
	
	public String updateBank(long id)
	
	{ 
		Bank b = iBankService.getById(id);
		displayBank(b);
	
		return "/update_bank.xhtml?faces-redirect=true";
	}
	
	 public void SaveChangesBank()
		
		{ iBankService.updateBank(new Bank(bankIdToBeUpdated, name,
				address,interest, email, phone, website));
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Bank updated successfuly");
	
		}
		

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	        FacesContext.getCurrentInstance().
	                addMessage(null, new FacesMessage(severity, summary, detail));
	 }
	
	
	
	private StreamedContent file;
	   
	   public StreamedContent getFile() {
		return file;
	}


	public void setFile(StreamedContent file) {
		this.file = file;
	}


	public void fileDownloadView() {
		  
		//agencyService.createPdf();
	       file = DefaultStreamedContent.builder()
	               .name("downloaded_boromir.jpg")
	               .contentType("image/jpg")
	               .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:/Users/ASUS-PC/Documents/workspace-sts-3.8.4.RELEASE/Dari-spring-boot/src/main/webapp/resources/reports/image.jpg"))
	               .build();
	   }
}
