package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.Transaction;
import com.dumbledore.mobrecharge.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	//save transaction
	public Transaction saveTransaction(Transaction transaction){
		return transactionRepository.save(transaction);
	}
	//display all transaction
	List<Transaction> showAll(){
		return transactionRepository.findAll();
	}
	
}
