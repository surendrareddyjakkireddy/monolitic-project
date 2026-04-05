package com.sms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.StudentEnquiryRepository;
import com.sms.model.StudentEnquiry;
import com.sms.service.StudentEnquiryService;


@Service
public class StudentEnquiryServiceImpl implements StudentEnquiryService{

	Logger logger=LoggerFactory.getLogger(StudentEnquiryServiceImpl.class);
	@Autowired
	private StudentEnquiryRepository studentEnquiryRepository;
	
	@Transactional
	public StudentEnquiry createStudentEnquiry(StudentEnquiry studentEnquiry) {
		try {
			studentEnquiry=studentEnquiryRepository.save(studentEnquiry);
		} catch (Exception e) {
			logger.error("studentEnquiry is not created");
		}
		return studentEnquiry;
	}

	@Transactional
	public StudentEnquiry updateStudentEnquiry(StudentEnquiry studentEnquiry) {
		try {
			studentEnquiry=studentEnquiryRepository.save(studentEnquiry);
		} catch(Exception e) {
			logger.error("studentEnquiry is not updated");
		}
		return studentEnquiry;
	}

	@Transactional
	public StudentEnquiry findById(Long studentId) {
		StudentEnquiry studentEnquiry=null;
		try {
			Optional<StudentEnquiry>  studentEnquiryOpt=studentEnquiryRepository.findById(studentId);
			if(studentEnquiryOpt.isPresent())
				studentEnquiry=studentEnquiryOpt.get();
		} catch (Exception e) {
			logger.error("studentEnquiry is not found");
		}
		return studentEnquiry;
	}

	@Transactional
	public List<StudentEnquiry> findAllStudentEnquiry() {
		try {
			List<StudentEnquiry> studentEnquiryList=studentEnquiryRepository.findAll();
			return studentEnquiryList;
		} catch (Exception e) {
			logger.error("studentEnquiryList is not found");
			return null;
		}
	}

	@Transactional
	public StudentEnquiry deleteStudentEnquiry(Long studentId) {
		StudentEnquiry studentEnquiry = null;
		try {
			studentEnquiry=this.findById(studentId);
			if(studentEnquiry!=null) {
				studentEnquiryRepository.deleteByStudentId(studentId);
			}
		} catch (Exception e) {
			logger.error("studentEnquiry is not deleted");
		}
		return studentEnquiry;
	}

}
