package com.capg.ocma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>{


}
