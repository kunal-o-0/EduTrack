package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrgAddDto;
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
	public List<OrgAddDto> getOrgList()
	{
		return orgService.getOrgList().stream().map((orgEnt)-> mapper.map(orgEnt, OrgAddDto.class)).collect(Collectors.toList());
	}
	
	@PostMapping
	public void addOrg(@RequestBody OrgAddDto org)
	{
		System.out.println(org.getOrgName());
		Organization orgEnt= orgService.addOrganization(org);
	}
}
