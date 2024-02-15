package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.head.HeadDto;
import com.app.entities.primary.Head;
import com.app.service.HeadService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/head")
public class HeadController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private HeadService headService;
	
	@GetMapping
	public List<HeadDto> getHeadList()
	{
		return headService.getHeadList();
	}
	
	@PostMapping("{orgId}")
	public ResponseEntity<?> addHead(@PathVariable Long orgId,@RequestBody HeadDto headDto)
	{
		Head head= headService.addHead(orgId ,headDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
