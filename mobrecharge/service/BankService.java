package com.dumbledore.mobrecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dumbledore.mobrecharge.model.BankAccount;
import com.dumbledore.mobrecharge.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;

	public BankAccount saveBankDetails(BankAccount bankAccount) {
		return bankRepository.save(bankAccount);
	}

	public List<BankAccount> getAllBankDetails() {
		return bankRepository.findAll();
	}

	public void deleteBankDetails() {
		bankRepository.deleteAll();

	}

	public BankAccount getDetailByAccountNumber(int bankId) {
		return bankRepository.findById(bankId).get();
	}

	public void deleteBankDetailbyAccountNumber(int bankId) {
		bankRepository.findById(bankId).get();

	}

}
