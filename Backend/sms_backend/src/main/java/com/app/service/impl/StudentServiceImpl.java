package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.OrganizationDao;
import com.app.dao.StudentDao;
import com.app.dto.student.StudDto;
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
	public List<StudDto> getStudentList() {
		return studDao.findAll()
						.stream()
						.map((studEnt)->
										{
											StudDto studDto=mapper.map(studEnt, StudDto.class);
											studDto.setOrgId(studEnt.getOrganization().getOrgId());
											studDto.setCourseId(studEnt.getCourse().getCourseId());
											return studDto;
										})
						.collect(Collectors.toList());
	}

	@Override
	public Student addStudent(Long orgId,Long courseId,StudDto studDto) {
		Student studEnt=mapper.map(studDto, Student.class);
		studEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		studEnt.setCourse(courseDao.findById(courseId).orElseThrow());
		return studDao.save(studEnt);
	}

	@Override
	public Student updateStud(Long studId, StudDto studDto) {
		Student studOld=studDao.findById(studId).orElseThrow();
		Student studNew=mapper.map(studDto, Student.class);
		studNew.setStudId(studOld.getStudId());
		studNew.setCourse(studOld.getCourse());
		studNew.setOrganization(studOld.getOrganization());
		return studDao.save(studNew);
	}

	@Override
	public void deleteStud(Long studId) {
		studDao.deleteById(studId);
		studDao.flush();
	}
}
