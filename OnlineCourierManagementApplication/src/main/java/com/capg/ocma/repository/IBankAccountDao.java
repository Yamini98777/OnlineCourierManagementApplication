package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.BankAccount;

@Repository
public interface IBankAccountDao extends JpaRepository<BankAccount, Long> {

}
