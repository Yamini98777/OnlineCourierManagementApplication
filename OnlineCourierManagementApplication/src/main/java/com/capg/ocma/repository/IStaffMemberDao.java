package com.capg.ocma.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ocma.entities.OfficeStaffMember;

/*
 * Author      : YAMINI C
 * Version     : 1.0
 * Date        : 03-04-2021
 * Description : This is Staff Member Repository
*/


@Repository
@Transactional
public interface IStaffMemberDao extends JpaRepository<OfficeStaffMember, Integer> {
	
	@Modifying
	@Query(value = "DELETE FROM office_staff_member WHERE office_outlet_office_id = :officeId",nativeQuery = true)
	public void deleteByofficeId(@Param("officeId") int officeId);
}
