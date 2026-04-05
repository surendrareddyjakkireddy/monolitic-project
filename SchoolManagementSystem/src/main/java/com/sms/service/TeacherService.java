package com.sms.service;

import java.util.List;

import com.sms.model.Teacher;

public interface TeacherService {

	public Teacher createTeacher(Teacher teacher);
	
	public Teacher updateTeacher(Teacher teacher);
	
	public Teacher findByTeacherId(Long teacherId);
	
	public List<Teacher> findAllTeacher();
	
	public Teacher deleteTeacher(Long teacherId);
}
