package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.StudentEnquiry;

@Repository
public interface StudentEnquiryRepository extends JpaRepository<StudentEnquiry, Long> {

	public StudentEnquiry deleteByStudentId(Long studentId);
}
