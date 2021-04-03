package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.CourierOfficeOutlet;

@Repository
public interface IOfficeOutletDao extends JpaRepository<CourierOfficeOutlet, Integer>{
	
}
