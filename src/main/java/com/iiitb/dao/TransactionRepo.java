package com.iiitb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, String>{

}
