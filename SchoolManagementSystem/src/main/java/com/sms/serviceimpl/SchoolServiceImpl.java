package com.sms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.SchoolRepository;
import com.sms.model.School;
import com.sms.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	Logger logger = LoggerFactory.getLogger(SchoolServiceImpl.class);
	@Autowired
	private SchoolRepository schoolRepo;

	@Transactional
	public School createSchool(School school) {
		/*
		 * Long schoolId = null; List<School> schoolList = this.findAllSchools();
		 * if(schoolList != null && !schoolList.isEmpty()) {
		 * //schoolList.sort(Comparator.comparing(School :: getSchoolId)); School
		 * dbSchool = schoolList.get(schoolList.size() - 1); schoolId =
		 * dbSchool.getSchoolId(); schoolId = schoolId + 1; } else { schoolId = 10001L;
		 * } school.setSchoolId(schoolId);
		 */
		try {
			school = schoolRepo.save(school);
			return school;
		} catch (Exception e) {
			logger.error("school is not updated");
			return null;
		}
	}

	@Transactional
	public School updateSchool(School school) {
		try {
			school = schoolRepo.save(school);
			return school;
		} catch (Exception e) {
			logger.error("school is not updated");
			return null;
		}
	}

	@Transactional
	public List<School> findAllSchools() {
		try {
			List<School> school = schoolRepo.findAll();
			return school;
		} catch (Exception e) {
			logger.error("schools are not found");
			return null;
		}
	}

	@Transactional
	public School deleteSchool(Long SchoolId) {
		School school = null;
		try {
			school = this.findBySchoolId(SchoolId);
			if (school != null) {
				schoolRepo.deleteBySchoolId(SchoolId);
			}
		} catch (Exception e) {
			logger.error("school is not deleted");
		}
		return school;
	}

	@Transactional
	public School findBySchoolId(Long schoolId) {
		School school = null;
		try {
			Optional<School> schoolOptObj = schoolRepo.findById(schoolId);
			if (schoolOptObj.isPresent()) {
				school = schoolOptObj.get();
			}
		} catch (Exception e) {
			logger.error("school not found");
		}
		return school;
	}
}
