package com.dumbledore.mobrecharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dumbledore.mobrecharge.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
