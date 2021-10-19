package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.Offer;

public interface OffersRepository extends JpaRepository<Offer , Integer> {
	
	

}
