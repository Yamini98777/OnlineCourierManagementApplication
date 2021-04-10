package com.capg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.OfficeStaffMember;

@Repository
public interface IStaffMemberDao extends JpaRepository<OfficeStaffMember, Integer> {
	
	
}
