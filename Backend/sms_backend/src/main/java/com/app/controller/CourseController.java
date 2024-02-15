package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.course.CourseDto;
import com.app.entities.secondary.Course;
import com.app.service.CourseService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<CourseDto> getCourseList()
	{
		return courseService.getCourseList();
	}
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto)
	{
		courseService.addCourse(courseDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable @NotNull Long courseId,@RequestBody CourseDto courseDto)
	{
		Course courseEnt=courseService.updateCourse(courseId, courseDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable @NotNull Long courseId)
	{
		courseService.deleteCourse(courseId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
