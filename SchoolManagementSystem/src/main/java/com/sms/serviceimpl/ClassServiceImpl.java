package com.sms.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.ClassRepository;
import com.sms.model.SchoolClass;
import com.sms.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);
	@Autowired
	private ClassRepository classRepository;

	@Transactional
	public SchoolClass createSchoolClass(SchoolClass schoolClass) {
		try {
			schoolClass = classRepository.save(schoolClass);
			return schoolClass;
		} catch (Exception e) {
			logger.error("class is not created");
			return null;
		}
	}

	@Transactional
	public SchoolClass updateSchoolClass(SchoolClass schoolClass) {
		try {
			schoolClass = classRepository.save(schoolClass);
			return schoolClass;
		} catch (Exception e) {
			logger.error("class is not updated");
			return null;
		}
	}

	@Transactional
	public List<SchoolClass> findAllSchoolClass() {
		try {
			List<SchoolClass> classList = classRepository.findAll();
			return classList;
		} catch (Exception e) {
			logger.error("class not found");
			return null;
		}
	}

	@Transactional
	public SchoolClass deleteClass(Long classId) {
		SchoolClass schoolClass = null;
		try {
			schoolClass = this.findByClassId(classId);
			if (schoolClass != null) {
				classRepository.deleteByClassId(classId);
			}
		} catch (Exception e) {
			logger.error("class is not delete");
		}
		return schoolClass;
	}

	@Transactional
	public SchoolClass findByClassId(Long classId) {
		SchoolClass schoolClass = null;
		try {
			schoolClass = classRepository.findByClassId(classId);
		} catch (Exception e) {
			logger.error("class not found");
		}
		return schoolClass;
	}
}
