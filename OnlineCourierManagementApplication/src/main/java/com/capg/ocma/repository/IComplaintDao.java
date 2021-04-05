package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;

@Repository
public interface IComplaintDao extends JpaRepository<Complaint, Integer> {


	
}
