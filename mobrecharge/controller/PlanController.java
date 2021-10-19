package com.dumbledore.mobrecharge.controller;

import com.dumbledore.mobrecharge.exception.InvalidArgumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.Plan;
import com.dumbledore.mobrecharge.service.OfferService;
import com.dumbledore.mobrecharge.service.PlanService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/plans")
public class PlanController {

	@Autowired
	PlanService planService;

	@Autowired
	OfferService offerService;

	@GetMapping("/{planId}")
	public ResponseEntity<?> showAllOffers() {
		return new ResponseEntity(offerService.getOffers(), HttpStatus.ACCEPTED);
	}

	@PostMapping
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		Plan savedPlan = planService.addingPlan(plan);
		return new ResponseEntity<Plan>(savedPlan, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> showAllPlans() {
		return new ResponseEntity(planService.getPlans(), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePlan(@PathVariable int id) {
		if (id <= 0) {
			throw new InvalidArgumentException("Invalid Id");
		}
		planService.deletingPlan(id);
		return new ResponseEntity("Plan Sucessfully Deleted !!", HttpStatus.ACCEPTED);
	}

}
