package com.app.service;

import java.util.List;

import com.app.dto.announcement.AnnounDto;
import com.app.entities.secondary.Announcement;

public interface AnnouncementService {
	List<AnnounDto> getAnnList();
	Announcement addAnnoun(Long orgId,AnnounDto announDto);
	Announcement updateAnnoun(Long announId,AnnounDto announDto);
	void deleteAnnoun(Long announId);
}
