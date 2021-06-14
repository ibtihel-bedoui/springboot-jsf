package tn.dari.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.dari.entities.Credit;

public interface ICreditService {

	public List<Credit> getAllCredit();
	public Credit afficherCredit(int id);
	public void addCredit (Credit credit);
	public void deleteCreditById(int CreditId) ;
	public void affectUserTOCredit(Long userID, int CreditID);
	public Credit updateCredit(Credit c);
	public void updateCreditByID(int CreditID);
	public Credit getById(int id);
	// Simulation d'un crédit bancaire (Calculs)
	public Double calculate_paiement(int CreditId);
	public float calculate_assurance_mois(int CreditID);
	public Double calculate_paiement_mois_total(int CreditID);
	public Double calculate_TAEG_Assurance(int CreditID);
	public Double calculate_TAEG_No_Assurance(int CreditID);
	public Double calculate_TAEA(int CreditID);
	public Double calculate_Total_Paye(int CreditID);
	public String decision_credit(int creditID);
	public void Simulate_credit(int CreditID);

	public int addOrUpdateSimulation(Credit credit);
	
}