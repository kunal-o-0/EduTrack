package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.entities.primary.Student;
import com.app.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentDao studDao;
	
	@Override
	public List<Student> getStudentList() {
		return studDao.findAll();
	}
}
