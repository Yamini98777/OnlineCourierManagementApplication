package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.Complaint;


@Repository
public interface IComplaintDao extends JpaRepository<Complaint, Integer> {
	
	


	
}
