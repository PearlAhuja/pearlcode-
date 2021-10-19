package com.dumbledore.mobrecharge.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dumbledore.mobrecharge.model.myenum.Gender;
import com.sun.istack.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer customerId;
	
	@NotNull private String firstName;
	@NotNull private String lastName;
	@NotNull private String email;
	private String password;
	@NotNull private Long mobileNumber;
	@NotNull private String dateOfBirth;
	@NotNull private Gender gender;
	@NotNull private String dateOfCreation;
	private String dateOfUpdate;
	
	
	/*
	 * Mapped ( Customer -> BankAccount )
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<BankAccount> bankAccountsList = new ArrayList<>();
	
	
	
	/*
	 * @Constructors
	 */
	public Customer() {
		super();
	}
	public Customer(String firstName, String lastName, String email, Long mobileNumber,
			String dateOfBirth, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.dateOfCreation = new Date().toString();
		this.dateOfUpdate = new Date().toString();
	}
	
	
	
	/*
	 * @Getters
	 * @Setters
	 */
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = new Date().toString();
	}
	public String getDateOfUpdate() {
		return dateOfUpdate;
	}
	public void setDateOfUpdate(String dateOfUpdate) {
		this.dateOfUpdate = new Date().toString();
	}

}
