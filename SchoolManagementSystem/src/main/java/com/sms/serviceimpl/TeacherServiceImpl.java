package com.sms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.TeacherRepository;
import com.sms.model.Teacher;
import com.sms.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
	@Autowired
	private TeacherRepository teacherRepository;

	public Teacher createTeacher(Teacher teacher) {
		try {
			teacher = teacherRepository.save(teacher);
		} catch (Exception e) {
			logger.error("teacher is not created");
		}
		return teacher;
	}

	public Teacher updateTeacher(Teacher teacher) {
		try {
			teacher = teacherRepository.save(teacher);
		} catch (Exception e) {
			logger.error("teacher is not updated");
		}
		return teacher;
	}

	public Teacher findByTeacherId(Long teacherId) {
		Teacher teacher = null;
		try {
			Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
			if (teacherOpt.isPresent()) {
				teacher = teacherOpt.get();
			}
		} catch (Exception e) {
			logger.error("teacher is not found");
		}
		return teacher;
	}

	public List<Teacher> findAllTeacher() {
		List<Teacher> teacher = null;
		try {
			teacher = teacherRepository.findAll();
		} catch (Exception e) {
			logger.error("teachers are not found");
		}
		return teacher;
	}

	public Teacher deleteTeacher(Long teacherId) {
		Teacher teacher = null;
		try {
			teacher = this.findByTeacherId(teacherId);
			if(teacher != null) {
				teacherRepository.deleteByTeacherId(teacherId);
			}
		} catch (Exception e) {
			logger.error("teacher is not deleted");
		}
		return teacher;
	}

}
