package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.StudentEnquiry;
import com.sms.service.StudentEnquiryService;

@RestController
@RequestMapping("api/studentEnquiry/v1")
public class StudentEnquiryController {
	
	Logger logger=LoggerFactory.getLogger(StudentEnquiryController.class);
	@Autowired
	private StudentEnquiryService studentEnquiryService;

	@PostMapping("/createStudentEnquiry")
	public ResponseEntity<StudentEnquiry> createStudentEnquiry(@RequestBody StudentEnquiry studentEnquiry) {
		try {
			studentEnquiry=studentEnquiryService.createStudentEnquiry(studentEnquiry);
		} catch (Exception e) {
			logger.error("error create in creation");
		}
		return new ResponseEntity<>(studentEnquiry, HttpStatus.CREATED);
	}

	@PutMapping("/updateStudentEnquiry")
	public ResponseEntity<StudentEnquiry> updateStudentEnquiry(@RequestBody StudentEnquiry studentEnquiry) {
		try {
			studentEnquiry=studentEnquiryService.updateStudentEnquiry(studentEnquiry);
		} catch(Exception e) {
			logger.error("error create in updation");
		}
		return new ResponseEntity<>(studentEnquiry, HttpStatus.OK);
	}

	
	@GetMapping("/findByIdStudentEnquiry")
	public ResponseEntity<StudentEnquiry> findById(@RequestParam Long studentId) {
		StudentEnquiry studentEnquiry=null;
		try {
			  studentEnquiry=studentEnquiryService.findById(studentId);
			
		} catch (Exception e) {
			logger.error("studentEnquiry is not found");
		}
		return new ResponseEntity<>(studentEnquiry, HttpStatus.OK);
	}

	@GetMapping("/findAllStudentEnquiry")
	public ResponseEntity<List<StudentEnquiry>> findAllStudentEnquiry() {
		List<StudentEnquiry> studentEnquiryList=null;
		try {
			 studentEnquiryList=studentEnquiryService.findAllStudentEnquiry();
		} catch (Exception e) {
			logger.error("error create in findAll");
		}
		return new ResponseEntity<>(studentEnquiryList, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStudentEnquiry")
	public ResponseEntity<StudentEnquiry> deleteStudentEnquiry(@RequestParam Long studentId) {
		StudentEnquiry studentEnquiry = null;
		try {
			studentEnquiry=studentEnquiryService.deleteStudentEnquiry(studentId);
		} catch (Exception e) {
			logger.error("error create in deletion");
		}
		return new ResponseEntity<>(studentEnquiry, HttpStatus.OK);
	}

}
