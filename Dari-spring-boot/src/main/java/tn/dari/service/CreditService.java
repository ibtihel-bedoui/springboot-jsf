package tn.dari.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import tn.dari.entities.Category;
import tn.dari.entities.Credit;
import tn.dari.entities.User;
import tn.dari.repository.CreditRep;
import tn.dari.repository.UserRep;

@Service
public class CreditService implements ICreditService {
	@Autowired
	CreditRep creditRep;
	@Autowired
	UserRep userRepository;
	@Autowired
	MailService mails;

	@Override
	public void addCredit(Credit c) {

		creditRep.save(c);

	}
	
	@Override
	public int addOrUpdateSimulation(Credit loanSimulation) {

		creditRep.save(loanSimulation);
		return loanSimulation.getId_credit();
	}
	@Override
	public void updateCreditByID(int CreditID) {
		Credit c = creditRep.findById(CreditID).get();
		creditRep.save(c);
	} 
	
	@Override
	public void deleteCreditById(int CreditId) {
		Credit c = creditRep.findById(CreditId).orElse(null);
		creditRep.delete(c);

	}
	
	@Override
	public Credit updateCredit(Credit c){
		return creditRep.save(c);
	}
	
	@Override
	public List<Credit> getAllCredit() {
	return (List<Credit>) creditRep.findAll();
	}
	@Override
	public Credit getById(int id) {
		
		return creditRep.findById(id).get();
	}
	
	@Override
	public Double calculate_paiement (int CreditId) {
		Credit credit = creditRep.findById(CreditId).get();
		float montant = credit.getMontant();
		float taux_interet = credit.getTaux_interet();
		float duree = credit.getDuree();
		float duree_mois = duree * 12;

		double paiement_mois = (montant * ((taux_interet*0.1) / 12)
				/ (1 - (Math.pow((1 / (1 + ((taux_interet*0.1) / 12))), duree_mois))));


		double res = (double) Math.round(paiement_mois * 100) / 100;

		credit.setPaiement_mois(res);
		creditRep.save(credit);
		System.out.println("Paiement par mois :" + res);
		return res;
	}
	@Override
	public Credit afficherCredit(int id) {
		return creditRep.findById(id).orElse(null);
	}
	
	@Override
	public void affectUserTOCredit(Long userID, int CreditID) {
		User userManagedEntity = userRepository.findById(userID).get();
		Credit CreditManagedEntity = creditRep.findById(CreditID).get();

		CreditManagedEntity.setUser(userManagedEntity);
		creditRep.save(CreditManagedEntity);
	}
	
	@Override
	public float calculate_assurance_mois (int CreditID) {
		Credit credit = creditRep.findById(CreditID).get();
		float assurance = credit.getAssurance();
		float duree = credit.getDuree();
		float duree_mois = duree * 12;
		float assurance_mois = assurance / duree_mois;
		credit.setAssurance(assurance_mois);
		creditRep.save(credit);
		System.out.println("Insurance Per Month :" + assurance_mois);
		return assurance_mois;

	}
	@Override
	public Double calculate_paiement_mois_total(int CreditID) {

		Credit credit = creditRep.findById(CreditID).get();
		Double paiement_mois = credit.getPaiement_mois();
		float duree = credit.getDuree();
		float duree_mois = duree * 12;
		float frais_dossier = credit.getFrais_dossier();

		Double paiement_total = (paiement_mois * duree_mois) + frais_dossier;
		credit.setPaiement_total(paiement_total);
		creditRep.save(credit);
		System.out.println("Total Monthly Payment :" + paiement_total);
		return paiement_total;
	}
	
	@Override
	public Double calculate_TAEG_Assurance(int CreditID) {
		Credit credit = creditRep.findById(CreditID).get();
		float amount = credit.getMontant();
		float additional_fees = credit.getFrais_dossier();
		float personal_contributaion = credit.getApport_personnel();
		float amount_borrowed = (amount + additional_fees) - personal_contributaion;
		Double total_monthly_payment = credit.getPaiement_total(); 																
		float insurance_per_month = credit.getAssurance();
		float duration_year = credit.getDuree();
		float duration_month = duration_year * 12;

		Double total_monthly_payment_insurance = total_monthly_payment + (insurance_per_month * duration_month);
		Double taeg_insurance = (total_monthly_payment_insurance - amount_borrowed) / (amount_borrowed * 12);
		double res = (double) Math.round(taeg_insurance * 100) / 100;

		credit.setTaeg_assurance(res);
		creditRep.save(credit);
		System.out.println("TARG With Insurance:" + res);
		return res;
	}
	
	@Override
	public Double calculate_TAEG_No_Assurance(int CreditID) {

		Credit credit = creditRep.findById(CreditID).get();
		float montant = credit.getMontant();
		float additional_fees = credit.getFrais_dossier();
		float apport_personnel = credit.getApport_personnel();
		float amount_borrowed = (montant + additional_fees) - apport_personnel;

		Double total_monthly_payment = credit.getPaiement_total(); 
		Double taeg_no_insurance = (total_monthly_payment - amount_borrowed) / (amount_borrowed * 12);
		double res = (double) Math.round(taeg_no_insurance * 100) / 100;

		credit.setTaeg(res);
		creditRep.save(credit);
		System.out.println("TARG No Insurance:" + res);
		return res;
	}
	
	@Override
	public Double calculate_TAEA(int CreditID) {
		Credit credit = creditRep.findById(CreditID).get();
		Double taeg_no_assurance = credit.getTaeg();
		Double taeg_assurance = credit.getTaeg_assurance();
		Double taea = taeg_assurance - taeg_no_assurance;
		double res = (double) Math.round(taea * 100) / 100;
		credit.setTaea(res);
		creditRep.save(credit);
		System.out.println("TAEA:" + res);
		return taea;
	}

	@Override
	public Double calculate_Total_Paye(int CreditID) {
		Credit credit = creditRep.findById(CreditID).get();

		Double paiement_total = credit.getPaiement_total();
		float montant = credit.getMontant();

		Double total_paye = paiement_total - montant;
		credit.setTotal_paye(total_paye);;
		creditRep.save(credit);
		System.out.println("Total Paid :" + total_paye);
		return total_paye;
	}
	
	@Override
	public String decision_credit(int creditID) {
		Credit credit = creditRep.findById(creditID).get();
		String result = "";
		Category category = credit.getCategory();
		Double k = 0.0;
		Double max = 0.0;
		Double monthly_payment = credit.getPaiement_mois();
		Double net_salary = (double) credit.getSalaire_net();
		if (category == Category.Apartment) {
			k = 0.65;
			max = net_salary * k;

			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.House) {

			k = 0.70;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.Land) {
			k = 0.50;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		} else if (category == Category.LocalCommercial) {

		} else {
			k = 0.69;
			max = net_salary * k;
			if (monthly_payment <= max) {
				result = "Accepted";
			} else {
				result = "Denied";

			}

		}

		credit.setResult(result);

		creditRep.save(credit);
		System.out.println("Result:" + result);
		return result;
	}

	
	
	@Override
	public void Simulate_credit(int CreditID) {
		
		calculate_assurance_mois( CreditID);
		calculate_paiement(CreditID);
		calculate_paiement_mois_total(CreditID);

		calculate_Total_Paye(CreditID);


		calculate_TAEG_Assurance(CreditID);
		calculate_TAEG_No_Assurance(CreditID);
		calculate_TAEA(CreditID);


		System.out.println("Simulation Done !!");
		mails.sendMail();
	}

	
}
