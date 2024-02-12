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

import com.app.dto.head.HeadAddDto;
import com.app.dto.head.HeadGetDto;
import com.app.service.HeadService;

@RestController
@RequestMapping("/head")
public class HeadController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private HeadService headService;
	
	@GetMapping
	public List<HeadGetDto> getHeadList()
	{
		return headService.getHeadList()
							.stream()
							.map((headEnt)->
											{
												HeadGetDto headDto=mapper.map(headEnt, HeadGetDto.class);
												headDto.setOrgId(headEnt.getOrganization().getOrgId());
												return headDto;
											})
							.collect(Collectors.toList());
	}
	
	@PostMapping("{orgId}")
	public String addHead(@PathVariable Long orgId,@RequestBody HeadAddDto headDto)
	{
		return headService.addHead(orgId ,headDto)!=null?"Success":"Failed";
	}
}
