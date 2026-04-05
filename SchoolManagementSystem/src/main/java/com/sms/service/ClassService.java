package com.sms.service;

import java.util.List;

import com.sms.model.SchoolClass;

public interface ClassService {

	public SchoolClass createSchoolClass(SchoolClass schoolClass);

	public SchoolClass updateSchoolClass(SchoolClass schoolClass);

	public List<SchoolClass> findAllSchoolClass();

	public SchoolClass deleteClass(Long classId);
	
	public SchoolClass findByClassId(Long classId);
}
