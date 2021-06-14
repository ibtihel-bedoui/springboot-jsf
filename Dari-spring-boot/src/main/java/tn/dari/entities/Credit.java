package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_credit")
public class Credit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_credit")
	private int id_credit;
	private Integer montant;
	private Integer duree;
	private Double paiement_mois;
	private float taux_interet;
	private float salaire_net;
	private float assurance;
	private float frais_dossier;
	private float apport_personnel;
	private Double paiement_total;
	private Double taeg;
	private Double taeg_assurance;
	private Double taea;
	private Double total_paye;
	private Double interet_total;
	private String result;
	
	
	
	@Enumerated(EnumType.STRING)
	Category category;
	@ManyToOne 
	Bank bank;
	@ManyToOne
	User user;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public float getSalaire_net() {
		return salaire_net;
	}
	public void setSalaire_net(float salaire_net) {
		this.salaire_net = salaire_net;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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



	public float getAssurance() {
		return assurance;
	}
	public void setAssurance(float assurance) {
		this.assurance = assurance;
	}
	
	
	public Credit(int id_credit, Integer montant, Integer duree, Double paiement_mois, float taux_interet,
			float salaire_net, float assurance, Category category, Bank bank, User user) {
		super();
		this.id_credit = id_credit;
		this.montant = montant;
		this.duree = duree;
		this.paiement_mois = paiement_mois;
		this.taux_interet = taux_interet;
		this.salaire_net = salaire_net;
		this.assurance = assurance;
		this.category = category;
		this.bank = bank;
		this.user = user;
	}

	
	public Credit(int id_credit, Integer montant, Integer duree, Double paiement_mois, float taux_interet,
			float salaire_net, float assurance, float frais_dossier, float apport_personnel, Double paiement_total,
			Double taeg, Double taeg_assurance, Double taea, Double total_paye, Double interet_total, Category category,
			Bank bank, User user) {
		super();
		this.id_credit = id_credit;
		this.montant = montant;
		this.duree = duree;
		this.paiement_mois = paiement_mois;
		this.taux_interet = taux_interet;
		this.salaire_net = salaire_net;
		this.assurance = assurance;
		this.frais_dossier = frais_dossier;
		this.apport_personnel = apport_personnel;
		this.paiement_total = paiement_total;
		this.taeg = taeg;
		this.taeg_assurance = taeg_assurance;
		this.taea = taea;
		this.total_paye = total_paye;
		this.interet_total = interet_total;
		this.category = category;
		this.bank = bank;
		this.user = user;
	}
	
	


	public Credit(int id_credit, Integer montant, Integer duree, Double paiement_mois, float taux_interet,
			float salaire_net, float assurance, float frais_dossier, float apport_personnel, Double paiement_total,
			Double taeg, Double taeg_assurance, Double taea, Double total_paye, Double interet_total, String result,
			Category category, Bank bank, User user) {
		super();
		this.id_credit = id_credit;
		this.montant = montant;
		this.duree = duree;
		this.paiement_mois = paiement_mois;
		this.taux_interet = taux_interet;
		this.salaire_net = salaire_net;
		this.assurance = assurance;
		this.frais_dossier = frais_dossier;
		this.apport_personnel = apport_personnel;
		this.paiement_total = paiement_total;
		this.taeg = taeg;
		this.taeg_assurance = taeg_assurance;
		this.taea = taea;
		this.total_paye = total_paye;
		this.interet_total = interet_total;
		this.result = result;
		this.category = category;
		this.bank = bank;
		this.user = user;
	}
	
	public Credit(int id_credit, Integer montant, Integer duree, float taux_interet, float salaire_net,
			float frais_dossier, float apport_personnel) {
		super();
		this.id_credit = id_credit;
		this.montant = montant;
		this.duree = duree;
		this.taux_interet = taux_interet;
		this.salaire_net = salaire_net;
		this.frais_dossier = frais_dossier;
		this.apport_personnel = apport_personnel;
	}
	
	

	public Credit(Integer montant, Integer duree, float taux_interet, float salaire_net, float frais_dossier,
			float apport_personnel) {
		super();
		this.montant = montant;
		this.duree = duree;
		this.taux_interet = taux_interet;
		this.salaire_net = salaire_net;
		this.frais_dossier = frais_dossier;
		this.apport_personnel = apport_personnel;
	}
	@Override
	public String toString() {
		return "Credit [id_credit=" + id_credit + ", montant=" + montant + ", duree=" + duree + ", paiement_mois="
				+ paiement_mois + ", taux_interet=" + taux_interet + ", salaire_net=" + salaire_net + ", assurance="
				+ assurance + ", frais_dossier=" + frais_dossier + ", apport_personnel=" + apport_personnel
				+ ", paiement_total=" + paiement_total + ", taeg=" + taeg + ", taeg_assurance=" + taeg_assurance
				+ ", taea=" + taea + ", total_paye=" + total_paye + ", interet_total=" + interet_total + ", result="
				+ result + ", category=" + category + ", bank=" + bank + ", user=" + user + "]";
	}
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}



