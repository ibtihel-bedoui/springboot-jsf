package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @OneToOne (mappedBy="user")
	private Bank bank;

	@OneToMany(mappedBy = "user")
	private Set<Credit> Credit;
    
    public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String e_mail;
	private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date date;


    
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Credit> getCredit() {
		return Credit;
	}

	public void setCredit(Set<Credit> credit) {
		Credit = credit;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	

	public User(Long id, Bank bank, Set<tn.dari.entities.Credit> credit, String firstName, String lastName,
			String e_mail, String phoneNumber, Date date) {
		super();
		this.id = id;
		this.bank = bank;
		Credit = credit;
		this.firstName = firstName;
		this.lastName = lastName;
		this.e_mail = e_mail;
		this.phoneNumber = phoneNumber;
		this.date = date;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", bank=" + bank + ", Credit=" + Credit + ", firstName=" + firstName + ", lastName="
				+ lastName + ", e_mail=" + e_mail + ", phoneNumber=" + phoneNumber + ", date=" + date + "]";
	}






}

