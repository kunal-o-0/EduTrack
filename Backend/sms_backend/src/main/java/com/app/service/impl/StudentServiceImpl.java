package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.OrganizationDao;
import com.app.dao.StudentDao;
import com.app.dto.student.StudAddDto;
import com.app.entities.primary.Organization;
import com.app.entities.primary.Student;
import com.app.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentDao studDao;
	@Autowired
	private OrganizationDao orgDao;
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Student> getStudentList() {
		return studDao.findAll();
	}

	@Override
	public Student addStudent(Long orgId,Long courseId,StudAddDto studDto) {
		Student studEnt=mapper.map(studDto, Student.class);
		studEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		studEnt.setCourse(courseDao.findById(courseId).orElseThrow());
		return studDao.save(studEnt);
	}
}
