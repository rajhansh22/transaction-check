package com.iiitb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.model.Transaction;
public interface TempTransactionRepo extends JpaRepository<Transaction, String>{

}
