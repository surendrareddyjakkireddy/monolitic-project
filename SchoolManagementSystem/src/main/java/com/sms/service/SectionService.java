package com.sms.service;

import java.util.List;

import com.sms.model.Section;

public interface SectionService {

	public Section createSection(Section section);
	
	public Section updateSection(Section section);
	
	public List<Section> findAllSections();
	
	public Section findBySectionId(Long sectionId);
	
	public Section deleteSection(Long sectionId);
}
