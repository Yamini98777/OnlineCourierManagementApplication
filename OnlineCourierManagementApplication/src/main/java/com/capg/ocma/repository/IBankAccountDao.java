package com.capg.ocma.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.BankAccount;

/*
 * Author      : PRADHIEEP K
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is BankAccount Repository
*/

@Repository
public interface IBankAccountDao extends JpaRepository<BankAccount, Long> {

	
}