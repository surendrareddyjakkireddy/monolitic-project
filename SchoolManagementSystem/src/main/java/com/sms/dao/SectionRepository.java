package com.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long>{

	public Section deleteBySectionId(Long sectionId);

}
