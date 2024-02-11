package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDto;
import com.app.entities.primary.Student;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studService;
	
	@GetMapping
	public List<Student> getStudents()
	{
		return studService.getStudentList();
	}
	
	@PostMapping("/{orgId}")
	public void addStudent(@RequestBody StudentDto stud)
	{
		
	}
}
