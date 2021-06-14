package tn.dari.controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.dari.entities.Bank;
import tn.dari.entities.Credit;
import tn.dari.repository.UserRep;
import tn.dari.service.IBankService;
import tn.dari.service.ICreditService;

@Scope(value = "session")
@Controller(value = "creditController")
@ELBeanName(value = "creditController")
@Join(path = "/", to = "/login.jsf")
public class CreditController {

	@Autowired 
	ICreditService iCreditService;
	@Autowired
	IBankService iBankService;

	@Autowired
	UserRep userRepository;
	
	
	public void addCredit() {
		iCreditService.addCredit(new Credit(id_credit,montant,duree,taux_interet, salaire_net, frais_dossier, apport_personnel));
		
		}
	
	public void deleteCreditByID(int CreditId) {

		iCreditService.deleteCreditById(CreditId);

	}
	public void affectUserTOCredit(Long userID, int CreditID) {
		iCreditService.affectUserTOCredit(userID, CreditID);

	}
	public void updateCreditByID(int CreditID) {
		iCreditService.updateCreditByID(CreditID);

	}
	
	public List<Credit> getCredits() {
		credits = iCreditService.getAllCredit();
		return credits;
		}

	
	public Credit getCreditByID(int CreditID) {

		return iCreditService.afficherCredit(CreditID);
	}
	

	
	// -----------------------------------Calcul-----------------------------------------
	public Double calculate_Payment(int CreditId) {
	
		return iCreditService.calculate_paiement(CreditId);
	}
	
	public Double calculate_Total_Monthly_Payment(int CreditID) {

		return iCreditService.calculate_paiement_mois_total(CreditID);
	}
	public void calculate_Insurance_Per_Month(int CreditID) {

		iCreditService.calculate_assurance_mois(CreditID);
	}
	
	public Double calculate_TAEG_No_Insurance(int CreditID) {

		return iCreditService.calculate_TAEG_No_Assurance(CreditID);
	}

	public Double calculate_TAEG_With_Insurance(int CreditID) {

		return iCreditService.calculate_TAEG_Assurance(CreditID);
	}
	public Double calculate_TAEA(int CreditID) {

		return iCreditService.calculate_TAEA(CreditID);
	}
	public Double calculate_Total_Paid(int CreditID) {

		return iCreditService.calculate_Total_Paye(CreditID);
	}
	public void Simulate_Credit(int CreditID) {
		iCreditService.Simulate_credit(CreditID);
	}
	
	/*public String addSimulation() {
	

		iCreditService.addOrUpdateSimulation(new Credit(montant, duree, taux_interet, salaire_net,
				apport_personnel, frais_dossier));

		return "/simulation_form.xhtml?faces-redirect=true";
	}*/
	
	
	// ----------------------------------JSF Simulation
	
	private int id_credit;
	private Integer montant;
	private Integer duree;
	private Double paiement_mois;
	private float taux_interet;
	private float salaire_net;
	private float frais_dossier;
	private float apport_personnel;
	
	private float assurance;
	private Double paiement_total;
	private Double taeg;
	private Double taeg_assurance;
	private Double taea;
	private Double total_paye;
	private Double interet_total;
	private Credit credit = new Credit();
	private List<Credit> credits;
	

	public ICreditService getiCreditService() {
		return iCreditService;
	}
	public void setiCreditService(ICreditService iCreditService) {
		this.iCreditService = iCreditService;
	}
	public IBankService getiBankService() {
		return iBankService;
	}
	public void setiBankService(IBankService iBankService) {
		this.iBankService = iBankService;
	}
	public UserRep getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRep userRepository) {
		this.userRepository = userRepository;
	}
	public int getId_credit() {
		return id_credit;
	}
	public void setId_credit(int id_credit) {
		this.id_credit = id_credit;
	}
	public Integer getMontant() {
		return montant;
	}
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Double getPaiement_mois() {
		return paiement_mois;
	}
	public void setPaiement_mois(Double paiement_mois) {
		this.paiement_mois = paiement_mois;
	}
	public float getTaux_interet() {
		return taux_interet;
	}
	public void setTaux_interet(float taux_interet) {
		this.taux_interet = taux_interet;
	}
	public float getSalaire_net() {
		return salaire_net;
	}
	public void setSalaire_net(float salaire_net) {
		this.salaire_net = salaire_net;
	}
	public float getFrais_dossier() {
		return frais_dossier;
	}
	public void setFrais_dossier(float frais_dossier) {
		this.frais_dossier = frais_dossier;
	}
	public float getApport_personnel() {
		return apport_personnel;
	}
	public void setApport_personnel(float apport_personnel) {
		this.apport_personnel = apport_personnel;
	}
	public float getAssurance() {
		return assurance;
	}
	public void setAssurance(float assurance) {
		this.assurance = assurance;
	}
	public Double getPaiement_total() {
		return paiement_total;
	}
	public void setPaiement_total(Double paiement_total) {
		this.paiement_total = paiement_total;
	}
	public Double getTaeg() {
		return taeg;
	}
	public void setTaeg(Double taeg) {
		this.taeg = taeg;
	}
	public Double getTaeg_assurance() {
		return taeg_assurance;
	}
	public void setTaeg_assurance(Double taeg_assurance) {
		this.taeg_assurance = taeg_assurance;
	}
	public Double getTaea() {
		return taea;
	}
	public void setTaea(Double taea) {
		this.taea = taea;
	}
	public Double getTotal_paye() {
		return total_paye;
	}
	public void setTotal_paye(Double total_paye) {
		this.total_paye = total_paye;
	}
	public Double getInteret_total() {
		return interet_total;
	}
	public void setInteret_total(Double interet_total) {
		this.interet_total = interet_total;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	
	
	

	
	
}
