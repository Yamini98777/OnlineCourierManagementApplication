package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.CourierOfficeOutlet;

/*
 * Author      : GOMATHI M
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is Complaint Repository
*/


@Repository
public interface IOfficeOutletDao extends JpaRepository<CourierOfficeOutlet, Integer> {
	
}
