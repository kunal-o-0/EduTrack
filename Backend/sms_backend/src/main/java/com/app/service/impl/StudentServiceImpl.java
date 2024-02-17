package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.OrganizationDao;
import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dto.attendance.AttendDto;
import com.app.dto.student.StudAttendDto;
import com.app.dto.student.StudDto;
import com.app.dto.student.StudGetTransDto;
import com.app.dto.student.StudPerfDto;
import com.app.entities.primary.Organization;
import com.app.entities.primary.Student;
import com.app.entities.secondary.Performance;
import com.app.entities.secondary.Subject;
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
	@Autowired
	private SubjectDao subDao;
	
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

	@Override
	public List<StudAttendDto> getAttendance(Long studId) {
		Student studEnt=studDao.findById(studId).orElseThrow();
		return studEnt.getAttendances()
						.stream()
						.map((attendEnt)->
												{
													StudAttendDto studAttendDto=mapper.map(attendEnt, StudAttendDto.class);
													return studAttendDto;
												})
						.collect(Collectors.toList());
	}

	@Override
	public List<StudPerfDto> getPerformance(Long studId) {
		Student studEnt=studDao.findById(studId).orElseThrow();
		List<Performance> perforList=studEnt.getPerformances();
		List<StudPerfDto> studPerfList=perforList.stream()
													.map((perforEnt)->
																		{
																			StudPerfDto studPerfDto=mapper.map(perforEnt, StudPerfDto.class);
																			Subject subject=subDao.findById(perforEnt.getSubject().getSubId()).orElseThrow();
																			studPerfDto.setSubName(subject.getSubName());
																			studPerfDto.setSubTotalMarks(subject.getSubTotalMarks());
																			return studPerfDto;
																		})
													.collect(Collectors.toList());
		return studPerfList;
	}

	@Override
	public List<StudGetTransDto> getTransactions(Long studId) {
		Student studEnt=studDao.findById(studId).orElseThrow();
		List<StudGetTransDto> transactions=new ArrayList<>();
		studEnt.getFees().stream()
							.forEach((feeEnt)->
												{
													feeEnt.getTransactions().stream()
																			.forEach((transEnt)->
																									{
																										StudGetTransDto studGetTransDto= mapper.map(transEnt, StudGetTransDto.class);
																										studGetTransDto.setFeesType(feeEnt.getFeesType());
																										transactions.add(studGetTransDto);
																									});													
												});
		return transactions;
	}
}
