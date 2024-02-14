package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AnnouncementDao;
import com.app.dao.OrganizationDao;
import com.app.dto.announcement.AnnounDto;
import com.app.entities.secondary.Announcement;
import com.app.service.AnnouncementService;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AnnouncementDao announDao;
	@Autowired
	private OrganizationDao orgDao;
	
	@Override
	public List<Announcement> getAnnList() {
		return announDao.findAll();
	}
	@Override
	public Announcement addAnnoun(Long orgId,AnnounDto announDto) {
		Announcement announEnt=mapper.map(announDto, Announcement.class);
		announEnt.setOrganization(orgDao.findById(orgId).orElseThrow());
		return announDao.save(announEnt);
	}
}
