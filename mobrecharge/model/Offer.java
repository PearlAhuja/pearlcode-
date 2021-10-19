
package com.dumbledore.mobrecharge.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer offerId;

	// private String typeOfOffer;  
	private String validThru;
	float amount;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "plan_id", referencedColumnName = "planId")
	private Plan plan;
	



//	public String getTypeOfOffer() {
//		return typeOfOffer;
//	}
//
//	public void setTypeOfOffer(String typeOfOffer) {
//		this.typeOfOffer = typeOfOffer;
//	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String getValidThru() {
		return validThru;
	}

	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Offer() {
		super();
	}

	public Offer(Integer offerId , String validThru) {
		super();
		this.offerId =offerId ;
		this.validThru = validThru;
	}

}
