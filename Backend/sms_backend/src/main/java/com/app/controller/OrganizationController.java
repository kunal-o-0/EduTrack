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

import com.app.dto.organization.OrgDto;
import com.app.dto.organization.OrgAddHeadDto;
import com.app.entities.primary.Organization;
import com.app.service.OrganizationService;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	OrganizationService orgService;
	
	@GetMapping
	public List<OrgDto> getOrgList()
	{
		return orgService.getOrgList();
	}
	
	@PostMapping
	public ResponseEntity<?> addOrg(@RequestBody OrgDto org)
	{
		Organization orgEnt= orgService.addOrganization(org);
		return ResponseEntity.status(HttpStatus.CREATED)
								.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/add-head")
	public void addHead(OrgAddHeadDto orgDto)
	{
		orgService.addHead(orgDto);
	}
	
	@PutMapping("/{orgId}")
	public ResponseEntity<?> updateOrg(@PathVariable @NotNull(message = "organization id required") Long orgId,@RequestBody OrgDto orgDto)
	{
		Organization orgEnt=orgService.updateOrg(orgId, orgDto);
		return ResponseEntity.status(HttpStatus.CREATED)
								.body(new ResponseText(HttpStatus.CREATED.value(), "Successfully updated!"));
	}
	
	@DeleteMapping("/{orgId}")
	public ResponseEntity<?> deleteOrg(@PathVariable @NotNull Long orgId)
	{
		orgService.deleteOrg(orgId);
		return ResponseEntity.status(HttpStatus.OK)
								.body(new ResponseText(HttpStatus.OK.value(), "Successfully removed!"));
	}
}
