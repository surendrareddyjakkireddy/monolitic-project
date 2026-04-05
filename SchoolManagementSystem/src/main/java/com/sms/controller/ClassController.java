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

import com.sms.model.SchoolClass;
import com.sms.service.ClassService;

@RestController
@RequestMapping("api/class/v1")
public class ClassController {

	Logger logger = LoggerFactory.getLogger(ClassController.class);
	@Autowired
	private ClassService classService;

	@PostMapping("/createClass")
	public ResponseEntity<SchoolClass> createSchoolClass(@RequestBody SchoolClass schoolClass) {
		try {
			schoolClass = classService.createSchoolClass(schoolClass);
			return new ResponseEntity<SchoolClass>(schoolClass, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("error created in class creation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateClass")
	public ResponseEntity<SchoolClass> updateSchoolClass(@RequestBody SchoolClass schoolClass) {
		try {
			schoolClass = classService.updateSchoolClass(schoolClass);
			return new ResponseEntity<SchoolClass>(schoolClass, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in class updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAllClass")
	public ResponseEntity<List<SchoolClass>> findAllSchoolClass() {
		try {
			List<SchoolClass> schoolClass = classService.findAllSchoolClass();
			return new ResponseEntity<List<SchoolClass>>(schoolClass, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in find all class");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteClass")
	public ResponseEntity<SchoolClass> deleteSchoolClass(@RequestParam Long classId) {
		try {
			SchoolClass schoolClass = classService.deleteClass(classId);
			return new ResponseEntity<SchoolClass>(schoolClass, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in class deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}
	
	@GetMapping("findByClassId")
	public ResponseEntity<SchoolClass> findByClassId(@RequestParam Long classId) {
		SchoolClass schoolClass=null;
		try {
			schoolClass=classService.findByClassId(classId);
		} catch (Exception e) {
			logger.error("error created in find all class");
		}
		return new ResponseEntity<SchoolClass>(schoolClass, HttpStatus.OK);
	}
}
