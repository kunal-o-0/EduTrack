package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.SubjectDao;
import com.app.dto.subject.SubDto;
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
	public List<SubDto> getSubList() {
		return subDao.findAll()
						.stream()
						.map((subEnt)->
										{
											SubDto subDto=mapper.map(subEnt, SubDto.class);
											subDto.setCourseId(subEnt.getCourse().getCourseId());
											return subDto;
										})
						.collect(Collectors.toList());
	}
	@Override
	public Subject addSub(Long courseId, SubDto subDto) {
		Subject subEnt=mapper.map(subDto, Subject.class);
		subEnt.setCourse(courseDao.findById(courseId).orElseThrow());
		return subDao.save(subEnt);
	}
}
