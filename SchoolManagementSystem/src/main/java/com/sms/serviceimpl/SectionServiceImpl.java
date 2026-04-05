package com.sms.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.SectionRepository;
import com.sms.model.Section;
import com.sms.service.SectionService;


@Service
public class SectionServiceImpl implements SectionService {

	Logger logger=LoggerFactory.getLogger(SectionServiceImpl.class);
	@Autowired
	private SectionRepository sectionRepository;
	
	@Transactional
	public Section createSection(Section section) {
		try {
			 section = sectionRepository.save(section);
		} catch (Exception e) {
			logger.error("section is not created");
		}
		return section;
	}

	@Transactional
	public Section updateSection(Section section) {
		try {
			section=sectionRepository.save(section);
		} catch (Exception e) {
			logger.error("section is not updated");
		}
		return section;
	}

	@Transactional
	public List<Section> findAllSections() {
		List<Section> section=null;
		try {
			 section=sectionRepository.findAll();
		} catch (Exception e) {
			logger.error("sections not found");
		}
		return section;
	}

	@Transactional
	public Section deleteSection(Long sectionId) {
		try {
			Section section=sectionRepository.deleteBySectionId(sectionId);
			 return section;
		} catch (Exception e) {
			logger.error("section is not deleted");
			return null;
		}
	}

	@Transactional
	public Section findBySectionId(Long sectionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
