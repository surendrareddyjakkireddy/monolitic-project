package com.sms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class SchoolClass {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "user_seq")
	@SequenceGenerator(allocationSize = 10001,name = "user_seq")
	private Long classId;
	private String className;
	@OneToMany( mappedBy = "schoolClass",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JsonManagedReference("schoolClass-section")
	private List<Section> section;
	private String status;

	/**
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the sections
	 */
	public List<Section> getsections() {
		return section;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setsections(List<Section> sections) {
		this.section = sections;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "SchoolClass [classId=" + classId + ", className=" + className + ", sections=" + section + ", status="
				+ status + "]";
	}

}
