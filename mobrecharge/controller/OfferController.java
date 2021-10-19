package com.dumbledore.mobrecharge.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dumbledore.mobrecharge.exception.InvalidArgumentException;
import com.dumbledore.mobrecharge.exception.ResourceNotFoundException;
import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.service.OfferService;

@RestController
@RequestMapping("/v1.0/mobrecharge/auth/offers")

public class OfferController {
	@Autowired
	OfferService offerService;

	@PostMapping
	public ResponseEntity<String> addOffer(@RequestBody Offer offer) {
		offerService.createOffer(offer);
		return new ResponseEntity<String>("Offer Sucessfully added !!", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllOffers() {
		return new ResponseEntity<>(offerService.getOffers(), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOffer(@PathVariable int id) {
		offerService.deleteOffer(id);
		return new ResponseEntity<>("Offer deleted !!", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> updateOffer(@PathVariable Integer id, @RequestBody Offer offer) {
		try { offerService.updateOffer(id,offer);
      		return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offer Not Found", exc);
		} catch (InvalidArgumentException exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad arguements", exc);
		}
	}

}
