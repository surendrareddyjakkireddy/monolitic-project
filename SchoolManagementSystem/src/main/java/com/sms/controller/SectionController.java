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

import com.sms.model.Section;
import com.sms.service.SectionService;

@RestController
@RequestMapping("api/section/v1")
public class SectionController {

	Logger logger = LoggerFactory.getLogger(SectionController.class);
	@Autowired
	private SectionService sectionService;

	@PostMapping("/createSection")
	public ResponseEntity<Section> createSection(@RequestBody Section section) {
		try {
			section = sectionService.createSection(section);
		} catch (Exception e) {
			logger.error("error created in section creation");
		}
		return new ResponseEntity<Section>(section, HttpStatus.CREATED);
	}

	@PutMapping("/updateSection")
	public ResponseEntity<Section> updateSection(@RequestBody Section section) {
		try {
			section = sectionService.updateSection(section);
			return new ResponseEntity<Section>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in section updation");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findAllSections")
	public ResponseEntity<List<Section>> findAllSections() {
		try {
			List<Section> section = sectionService.findAllSections();
			return new ResponseEntity<List<Section>>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("error created in find all sections");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/findBySectionId")
	public ResponseEntity<Section> findBySectionId(@RequestParam Long sectionId) {
		Section section=null;
		try {
			section=sectionService.findBySectionId(sectionId);
		} catch (Exception e) {
			logger.error("error created in finding section by id");
		}
		return new ResponseEntity<Section>(section, HttpStatus.OK);
	}
	

	@DeleteMapping("/deleteSection")
	public ResponseEntity<Section> deleteSection(@RequestParam Long sectionId) {
		Section section = null;
		try {
			section = sectionService.deleteSection(sectionId);
			logger.warn("con dl t->" + section.toString());
			return new ResponseEntity<Section>(section, HttpStatus.OK);
		} catch (Exception e) {
			logger.warn("con dl e->" + section.toString());
			logger.error("error created in section deletion");
			return new ResponseEntity<>(null, HttpStatus.TOO_MANY_REQUESTS);
		}
	}
}
