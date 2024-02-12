package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dto.course.CourseAddDto;
import com.app.entities.secondary.Course;
import com.app.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getCourseList() {
		return courseDao.findAll();
	}
	
	@Override
	public Course addCourse(CourseAddDto courseDto) {
		return courseDao.save(mapper.map(courseDto, Course.class));
	}
}
