package com.app.service;

import java.util.List;

import com.app.dto.course.CourseDto;
import com.app.entities.secondary.Course;

public interface CourseService {
	List<CourseDto> getCourseList();
	Course addCourse(CourseDto courseDto);
	Course updateCourse(Long courseId,CourseDto courseDto);
	void deleteCourse(Long courseId);
}
