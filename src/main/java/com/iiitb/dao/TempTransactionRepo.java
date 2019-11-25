package com.iiitb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiitb.model.TempTransaction;
public interface TempTransactionRepo extends JpaRepository<TempTransaction, String>{

}
