package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.announcement.AnnounDto;
import com.app.entities.secondary.Announcement;
import com.app.service.AnnouncementService;
import com.app.util.ResponseText;

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
		return announService.getAnnList();
	}
	
	@PostMapping
	public ResponseEntity<?> addAnnoun(@RequestBody AnnounDto announDto)
	{
		Announcement announEnt=announService.addAnnoun(announDto.getOrgId(), announDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{announId}")
	public ResponseEntity<?> updateAnnoun(@PathVariable @NotNull Long announId,@RequestBody AnnounDto announDto)
	{
		Announcement announEnt=announService.updateAnnoun(announId, announDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{announId}")
	public ResponseEntity<?> deleteAnnoun(@PathVariable @NotNull Long announId)
	{
		announService.deleteAnnoun(announId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
