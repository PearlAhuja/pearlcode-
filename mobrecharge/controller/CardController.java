package com.dumbledore.mobrecharge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.model.CardDetail;
import com.dumbledore.mobrecharge.service.BankService;
import com.dumbledore.mobrecharge.service.CardService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/accountdetails/card")
public class CardController {
	@Autowired
	CardService cardService;
	
	
	   @PostMapping
	    public String addNewCardDetails(@RequestBody CardDetail cardDetail)
	    {
	    	cardService.saveCardDetails(cardDetail);
	    	return "Card Details Successfully Added";	
	    	
	    }
	    
	    @GetMapping("/{nameOnCard}")
		public CardDetail getDetailsByUserName(@PathVariable String nameOnCard)
		{
			return cardService.getDetail(nameOnCard);
		}
	    
	    @DeleteMapping("/{nameOnCard}")
	    public String deleteCardDetailByNameOnCard(@PathVariable  String nameOnCard)
	    {
	    	cardService.deleteCardDetail(nameOnCard);
	    	return "Successfully Deleted CardDetails";
	    }

}
