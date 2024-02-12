package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.organization.OrgAddDto;
import com.app.dto.organization.OrgAddHeadDto;
import com.app.dto.organization.OrgGetDto;
import com.app.entities.primary.Organization;
import com.app.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	OrganizationService orgService;
	
	@GetMapping
	public List<OrgGetDto> getOrgList()
	{
		return orgService.getOrgList().stream()
										.map((orgEnt)-> mapper.map(orgEnt, OrgGetDto.class))
										.collect(Collectors.toList());
	}
	
	@PostMapping
	public void addOrg(@RequestBody OrgAddDto org)
	{
		System.out.println(org.getOrgName());
		Organization orgEnt= orgService.addOrganization(org);
	}
	
	@PutMapping("/add-head")
	public void addHead(OrgAddHeadDto orgDto)
	{
		orgService.addHead(orgDto);
	}
}
