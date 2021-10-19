package com.dumbledore.mobrecharge.model;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planId;
	
	private int validityOfPlan;
	private float amount;
	private String typeOfPlan;  //Try making enum
	
	@OneToMany(mappedBy = "plan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Offer>offerlist=new HashSet<>();
   
    
	public Plan() {
		super();
	}

	public Plan(int planId, int validityOfPlan, float amount, String typeOfPlan) {
		super();
		this.planId =planId ;
		this.validityOfPlan = validityOfPlan;
		this.amount = amount;
		this.typeOfPlan = typeOfPlan;
	}



	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getValidityOfPlan() {
		return validityOfPlan;
	}

	public void setValidityOfPlan(int validityOfPlan) {
		this.validityOfPlan = validityOfPlan;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTypeOfPlan() {
		return typeOfPlan;
	}

	public void setTypeOfPlan(String typeOfPlan) {
		this.typeOfPlan = typeOfPlan;
	}

}
