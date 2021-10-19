package com.dumbledore.mobrecharge.controller;

import java.util.List;

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

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.service.BankService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/accountdetails")
public class BankController {
	@Autowired
	BankService bankService;
	
	@GetMapping
	public ResponseEntity<List<BankAccount>> getAllDetails() {
		return new ResponseEntity<>(bankService.getAllBankDetails(), HttpStatus.OK);
	}
	
	
    @DeleteMapping
	public ResponseEntity<String> deleteAllBankDetails() {
		bankService.deleteBankDetails();
		return new ResponseEntity<>("Successfully Deleted Details", HttpStatus.ACCEPTED);
	}
	
  
    
    @PostMapping
    public ResponseEntity<String> addNewAccountDetails(@RequestBody BankAccount bankAccount) {
		bankService.saveBankDetails(bankAccount);
		return new ResponseEntity<>("Sucessfully added bank account", HttpStatus.CREATED);

	}

 
	@GetMapping("/{bankId}")
	public ResponseEntity<BankAccount> getDetailsByAccountNumber(@PathVariable int bankId ) {
		return new ResponseEntity<>(bankService.getDetailByAccountNumber(bankId), HttpStatus.OK);

	}

	@DeleteMapping("/{bankId}")
	public ResponseEntity<String> deleteAllBankDetails(@PathVariable int bankId) {
		bankService.deleteBankDetailbyAccountNumber(bankId);
		return new ResponseEntity<>("Successfully Deleted AccountDetails", HttpStatus.ACCEPTED);
	}
	

}
