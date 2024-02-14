package com.app.service;

import java.util.List;

import com.app.dto.course.CourseDto;
import com.app.entities.secondary.Course;

public interface CourseService {
	List<Course> getCourseList();
	Course addCourse(CourseDto courseDto);
}
