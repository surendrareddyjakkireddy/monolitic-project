package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.SchoolClass;

@Repository
public interface ClassRepository extends JpaRepository<SchoolClass, Long> {

	public SchoolClass deleteByClassId(Long classId);

	public SchoolClass findByClassId(Long classId);

	
}
