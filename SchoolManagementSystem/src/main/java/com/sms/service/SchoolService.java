package com.sms.service;

import java.util.List;

import com.sms.model.School;

public interface SchoolService {

	public School createSchool(School School);

	public School updateSchool(School School);

	public List<School> findAllSchools();

	public School deleteSchool(Long SchoolId);
	
	public School findBySchoolId(Long schoolId);
}
