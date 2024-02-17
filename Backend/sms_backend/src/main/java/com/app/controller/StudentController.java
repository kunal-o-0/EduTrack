package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.attendance.AttendDto;
import com.app.dto.student.StudAttendDto;
import com.app.dto.student.StudDto;
import com.app.dto.student.StudGetPendingFeesDto;
import com.app.dto.student.StudGetTransDto;
import com.app.dto.student.StudPerfDto;
import com.app.entities.primary.Student;
import com.app.service.CourseService;
import com.app.service.StudentService;
import com.app.util.CreatePayload;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000/")
public class StudentController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentService studService;
	
//	for getting all student list
	@GetMapping
	public ResponseEntity<?> getStudentList()
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<StudDto>("Student list",studService.getStudentList())); 
	}
	
//	for getting attendance of student by his/her id
	@GetMapping("/attendance/{studId}")
	public ResponseEntity<?> getAttendance(@PathVariable @NotNull Long studId)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<StudAttendDto>("Student's attendance list",studService.getAttendance(studId)));  
	}
	
//	for getting performance of student by id
	@GetMapping("/performance/{studId}")
	public ResponseEntity<?> getPerformances(@PathVariable @NotNull Long studId)
	{
		return ResponseEntity.status(HttpStatus.OK)
								.body(new CreatePayload<StudPerfDto>("Student's performance list", studService.getPerformance(studId)));
	}
	
//	for getting fee transactions by student id
	@GetMapping("/fees/get-trans/{studId}")
	public ResponseEntity<?> getTransactions(@PathVariable @NotNull Long studId)
	{
		return ResponseEntity.status(HttpStatus.OK)
								.body(new CreatePayload<StudGetTransDto>("All transaction made by student", studService.getTransactions(studId)));
	}
	
//	for getting pending fees list of student by students's id
	@GetMapping("/fees/get-pending/{studId}")
	public ResponseEntity<?> getPendingFees(@PathVariable @NotNull Long studId)
	{
		return ResponseEntity.status(HttpStatus.OK)
								.body(new CreatePayload<StudGetPendingFeesDto>("List of pending fees", studService.getPendingFees(studId)));
	}
	
//	for adding student
	@PostMapping
	public ResponseEntity<?> addStudent( @RequestBody StudDto studDto)
	{
		Student studEnt=studService.addStudent(studDto.getOrgId(),studDto.getCourseId(), studDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
//	for updating student details by student id
	@PutMapping("/{studId}")
	public ResponseEntity<?> updateStud(@PathVariable @NotNull Long studId,@RequestBody StudDto studDto)
	{
		Student studEnt=studService.updateStud(studId, studDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
//	for deleting student by id
	@DeleteMapping("/{studId}")
	public ResponseEntity<?> deleteStud(@PathVariable @NotNull Long studId)
	{
		studService.deleteStud(studId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
