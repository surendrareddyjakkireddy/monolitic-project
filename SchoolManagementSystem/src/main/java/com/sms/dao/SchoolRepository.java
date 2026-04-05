package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

	public School deleteBySchoolId(Long schoolId);
	
	

}
