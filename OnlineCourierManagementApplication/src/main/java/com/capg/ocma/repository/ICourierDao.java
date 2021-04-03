package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.Courier;

@Repository
public interface ICourierDao extends JpaRepository<Courier, Integer> {
	
}
