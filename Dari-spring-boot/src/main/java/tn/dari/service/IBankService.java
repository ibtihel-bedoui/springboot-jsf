package tn.dari.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.dari.entities.Bank;

public interface IBankService {
	public List<Bank> getAllBank();
	public Bank getById(long id);
	public void deleteBankById(Long BankId) ;
	public void ajouterBanque(Bank b);
	public Bank updateBank(Bank b);
	public long getNombreBankJPQL(String address);
	boolean createPdf(List<Bank> agencies, ServletContext context, HttpServletRequest request,
			HttpServletResponse response);

	

}

