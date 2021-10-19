package com.dumbledore.mobrecharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.Payment;
import com.dumbledore.mobrecharge.model.Transaction;
import com.dumbledore.mobrecharge.service.OfferService;
import com.dumbledore.mobrecharge.service.PaymentService;
import com.dumbledore.mobrecharge.service.PlanService;
import com.dumbledore.mobrecharge.service.TransactionService;

@RequestMapping("/v1.0/mobrecharge/auth/payments")
@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	PlanService planService;
	@Autowired
	OfferService offerService;

	// Make Payment after applying an offer using its offer id
	@PostMapping("/pay")
	public ResponseEntity<String> makePayment(@RequestBody Transaction transaction) {
		String result = "";
		int planId = transaction.getPlanId();
		int offerId = transaction.getOfferId();
		long phoneNumber = transaction.getPhoneNumber();

		float amount = paymentService.calculateAmount(planId, offerId);

		Payment payment = paymentService.saveAmount(amount);
		int payId = payment.getPaymentId();

		if (amount >= 0) {
			result += "Amount to be paid : ";
			result += (Float.toString(amount));
			result += "\n Payment Sucessfully Received !!";
		} else {
			result += "Recharge Unsuccessfull";
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}

		transaction.setPaymentId(payId);
		transactionService.saveTransaction(transaction);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<List<Payment>> Payments() {
		return new ResponseEntity<>(paymentService.getAllPayment(), HttpStatus.ACCEPTED);

	}

}
