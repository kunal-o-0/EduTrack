package com.app.service;

import java.util.List;

import com.app.dto.course.CourseAddDto;
import com.app.entities.secondary.Course;

public interface CourseService {
	List<Course> getCourseList();
	Course addCourse(CourseAddDto courseDto);
}
