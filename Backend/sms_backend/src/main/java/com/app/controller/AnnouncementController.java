package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.announcement.AnnounDto;
import com.app.entities.secondary.Announcement;
import com.app.service.AnnouncementService;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AnnouncementService announService;
	
	@GetMapping
	public List<AnnounDto> getAnnounList()
	{
		return announService.getAnnList()
							.stream()
							.map((announEnt)->
												{
													AnnounDto announDto=mapper.map(announEnt, AnnounDto.class);
													announDto.setOrgId(announEnt.getOrganization().getOrgId());
													return announDto;
												})
							.collect(Collectors.toList());
	}
	
	@PostMapping("/{orgId}")
	public void addAnnoun(@PathVariable Long orgId,@RequestBody AnnounDto announDto)
	{
		Announcement announEnt=announService.addAnnoun(orgId, announDto);
	}
}
