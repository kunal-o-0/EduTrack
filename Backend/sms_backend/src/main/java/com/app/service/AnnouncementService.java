package com.app.service;

import java.util.List;

import com.app.dto.announcement.AnnounAddDto;
import com.app.entities.secondary.Announcement;

public interface AnnouncementService {
	List<Announcement> getAnnList();
	Announcement addAnnoun(Long orgId,AnnounAddDto announDto);
}
