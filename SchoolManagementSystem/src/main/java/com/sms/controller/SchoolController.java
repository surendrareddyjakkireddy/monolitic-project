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

import com.sms.model.School;
import com.sms.service.SchoolService;

@RestController
@RequestMapping("api/school/v1")
public class SchoolController {

	Logger logger = LoggerFactory.getLogger(SchoolController.class);
	@Autowired
	private SchoolService schoolService;

	/*
	 * @PostMapping("/createSchool") public ResponseEntity<School>
	 * createSchool(@RequestBody School school) {
	 * logger.warn("createSchool-->controller"+school.toString()); school=
	 * schoolService.createSchool(school); return new ResponseEntity<School>(school,
	 * HttpStatusCode.valueOf(200)); }
	 */
	@PostMapping("/createSchool")
	public ResponseEntity<School> createSchool(@RequestBody School school) {
		try {
			school = schoolService.createSchool(school);
			return new ResponseEntity<>(school, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("error created in school creation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateSchool")
	public ResponseEntity<School> updateSchool(@RequestBody School school) {
		try {
			school = schoolService.updateSchool(school);
			return new ResponseEntity<School>(school, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in school updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findAllSchools")
	public ResponseEntity<List<School>> findAll() {
		try {
			List<School> schoolList = schoolService.findAllSchools();
			return new ResponseEntity<List<School>>(schoolList, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in school findAll");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/deleteSchool")
	public ResponseEntity<School> deleteSchool(@RequestParam Long schoolId) {
		try {
			School school = schoolService.deleteSchool(schoolId);
			return new ResponseEntity<School>(school, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in school deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}

	@GetMapping("/findById")
	public ResponseEntity<School> findBySchoolId(@RequestParam Long schoolId) {
		try {
			School school = schoolService.findBySchoolId(schoolId);
			return new ResponseEntity<School>(school, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in findById");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
