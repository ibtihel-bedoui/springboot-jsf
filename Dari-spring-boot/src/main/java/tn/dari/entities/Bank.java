package tn.dari.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_bank")
public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="INTEREST")
	private float interest;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private int phone;
	
	@Column(name="WEBSITE")
	private String website;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bank") 
	private Set<Credit> Credit;
    @OneToOne
	private User user;
    
    
	public Set<Credit> getCredit() {
		return Credit;
	}
	public void setCredit(Set<Credit> credit) {
		Credit = credit;
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", address=" + address + ", interest=" + interest + ", email="
				+ email + ", phone=" + phone + ", website=" + website + ", user=" + user + "]";
	}
	
	public Bank(Long id, String name, String address, float interest, String email, int phone, String website) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.interest = interest;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}
	public Bank(Long id, String name, String address, float interest, String email, int phone, String website,
			Set<tn.dari.entities.Credit> credit, User user) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.interest = interest;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.user = user;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
    



}
