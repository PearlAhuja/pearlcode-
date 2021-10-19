package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.Offer;
import com.dumbledore.mobrecharge.repository.OffersRepository;

@Service
public class OfferService {
	@Autowired
	OffersRepository offersRepository;

	// Get all Offers
	public List<Offer> getOffers() {
		return offersRepository.findAll();
	}

	// get offer by given id
	public Offer getOffersById(Integer id) {
		return offersRepository.findById(id).get();
	}

// -------------------------------- Admin Controls ------------------------------------
	// add offer
	public Offer createOffer(Offer offer) {
		return offersRepository.save(offer);
	}

	// delete offer
	public void deleteOffer(Integer id) {
		offersRepository.deleteById(id);
	}

	// Update Offer
	public void updateOffer(Integer id, Offer offer) {
		if (id == 0 || offer == null) {
			throw new RuntimeException("Offer does not exist");
		}
		Offer existingoffer = offersRepository.findById(id).get();
		existingoffer.setAmount(offer.getAmount());
		existingoffer.setValidThru(offer.getValidThru());

	}
}