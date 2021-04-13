package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.CourierOfficeOutlet;

/*
 * Author      : JEGANNATH P S
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is Office outlet Repository
*/


@Repository
public interface IOfficeOutletDao extends JpaRepository<CourierOfficeOutlet, Integer> {
	
}
