package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dto.course.CourseDto;
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
	public List<CourseDto> getCourseList() {
		return courseDao.findAll()
						.stream()
						.map((courseEnt)->
											{
												CourseDto courseDto=mapper.map(courseEnt, CourseDto.class);
												return courseDto;
											})
						.collect(Collectors.toList());
	}
	
	@Override
	public Course addCourse(CourseDto courseDto) {
		return courseDao.save(mapper.map(courseDto, Course.class));
	}

	@Override
	public Course updateCourse(Long courseId, CourseDto courseDto) {
		Course courseNew=mapper.map(courseDto, Course.class);
		Course courseOld=courseDao.findById(courseId).orElseThrow();
		courseNew.setCourseId(courseOld.getCourseId());
		return courseDao.save(courseNew);
	}

	@Override
	public void deleteCourse(Long courseId) {
		courseDao.deleteById(courseId);
		courseDao.flush();
	}
}
