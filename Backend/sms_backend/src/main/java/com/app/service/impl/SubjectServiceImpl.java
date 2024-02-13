package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.SubjectDao;
import com.app.dto.subject.SubAddDto;
import com.app.entities.secondary.Subject;
import com.app.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private SubjectDao subDao;
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Subject> getSubList() {
		return subDao.findAll();
	}
	@Override
	public Subject addSub(Long courseId, SubAddDto subDto) {
		Subject subEnt=mapper.map(subDto, Subject.class);
		subEnt.setCourse(courseDao.findById(courseId).orElseThrow());
		return subDao.save(subEnt);
	}
}
