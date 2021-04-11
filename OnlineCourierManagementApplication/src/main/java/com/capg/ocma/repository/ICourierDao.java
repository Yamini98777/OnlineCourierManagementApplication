package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.Courier;

/*
 * Author      : SRINIVAS MADIVAL
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is Courier Repository
*/

@Repository
public interface ICourierDao extends JpaRepository<Courier, Integer> {

	public Courier findByConsignmentNo(int consignmentNo);
	
}