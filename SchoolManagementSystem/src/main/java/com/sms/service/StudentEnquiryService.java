package com.sms.service;

import java.util.List;

import com.sms.model.StudentEnquiry;

public interface StudentEnquiryService {

	public StudentEnquiry createStudentEnquiry(StudentEnquiry studentEnquiry);
	
	public StudentEnquiry updateStudentEnquiry(StudentEnquiry studentEnquiry);
	
	public StudentEnquiry findById(Long studentId);
	
	public List<StudentEnquiry> findAllStudentEnquiry();
	
	public StudentEnquiry deleteStudentEnquiry(Long studentId);
}
