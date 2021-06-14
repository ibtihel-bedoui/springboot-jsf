package tn.dari.controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import tn.dari.entities.Bank;
import tn.dari.service.BankService;

@Named
@ViewScoped
public class ManageDialog implements Serializable {

	private List<Bank> banks;
	private Bank selectedBank;
	
	@Autowired
	BankService bankservice;
	
	public List<Bank> getBanks() {
		return banks;
	
	}
	


	public void setAgencies(List<Bank> banks) {
		this.banks = banks;
	}
	
	public Bank getSelectedBank() {
		return selectedBank;
	}



	public void setSelectedBank(Bank selectedBank) {
		this.selectedBank = selectedBank;
	}


	public void openNew() {
        this.selectedBank = new Bank();
        
    }
	
	  public void deleteBank() {
	        this.banks.remove(this.selectedBank);
	        this.selectedBank = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bank Removed"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-banks");
	


}

}
