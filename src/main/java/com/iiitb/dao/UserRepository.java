package com.iiitb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiitb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
