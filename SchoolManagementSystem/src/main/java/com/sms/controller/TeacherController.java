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

import com.sms.model.Teacher;
import com.sms.service.TeacherService;

@RestController
@RequestMapping("api/teacher/v1")
public class TeacherController {

	Logger logger = LoggerFactory.getLogger(TeacherController.class);
	@Autowired
	private TeacherService teacherService;

	@PostMapping("/createTeacher")
	public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
		try {
			teacher = teacherService.createTeacher(teacher);
		} catch (Exception e) {
			logger.error("error created teacher creation");
		}
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}

	@PutMapping("/updateTeacher")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
		try {
			teacher = teacherService.updateTeacher(teacher);
		} catch (Exception e) {
			logger.error("error created teacher updation");
		}
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}

	@GetMapping("/findByTeacherId")
	public ResponseEntity<Teacher> findByTeacherId(@RequestParam Long teacherId) {
		try {
			Teacher teacher = teacherService.findByTeacherId(teacherId);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in findByTeacherId");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAllTeachers")
	public ResponseEntity<List<Teacher>> findAllTeacher() {
		try {
			List<Teacher> teacherList = teacherService.findAllTeacher();
			return new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in teacher finding");
			return null;
		}
	}

	@DeleteMapping("/deleteTeacher")
	public ResponseEntity<Teacher> deleteTeacher(@RequestParam Long teacherId) {
		try {
			Teacher teacher = teacherService.deleteTeacher(teacherId);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in teacher deletion");
			return null;
		}
	}
}
