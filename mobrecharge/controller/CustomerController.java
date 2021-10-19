package com.dumbledore.mobrecharge.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.Customer;
import com.dumbledore.mobrecharge.service.CustomerService;

@RestController
@RequestMapping(value = "/v1.0/mobrecharge/auth/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/*
	 * @TestMapping
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Customer Endpoint working fine";
	}

	
	/*
	 * Login and Sign-up functionalities
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login() {
		customerService.signIn();
		return new ResponseEntity<>("signIn", HttpStatus.ACCEPTED);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup() {
		customerService.signUp();
		return new ResponseEntity<>("signUp", HttpStatus.CREATED);
	}

	@GetMapping("/getallcustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() { // LIST OF ALL CUSTOMERS
		return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/addcustomer")
	public ResponseEntity<String> addCustomers(@RequestBody Customer customer) {
		customer.setDateOfCreation((new Date()).toString()); // Date of creation
		customerService.addCustomer(customer);
		return new ResponseEntity<>("Customer Created Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{number}")
	public ResponseEntity<Customer> getCustomerByNumber(@PathVariable Long number) {
		return new ResponseEntity<>(customerService.findByNumber(number), HttpStatus.FOUND);
	}

	@PutMapping("/{number}/{newnumber}")
	public ResponseEntity<String> updateCustomerNumber(@PathVariable Long number, @PathVariable Long newNumber) {
		customerService.updateCustomer(number, newNumber);
		return new ResponseEntity<>("Customer Number Updated !!", HttpStatus.OK);
	}

	@DeleteMapping("/{number}")
	public ResponseEntity<String> deleteCustomerByNumber(@PathVariable Long number) {
		customerService.deleteCustomer(number);
		return new ResponseEntity<>("Customer details removed sucessfully", HttpStatus.OK);
	}

	@GetMapping("/services")
	public ResponseEntity<List<String>> getAllServices() {
		return new ResponseEntity<>(customerService.showAllServices(), HttpStatus.OK);
	}

}
