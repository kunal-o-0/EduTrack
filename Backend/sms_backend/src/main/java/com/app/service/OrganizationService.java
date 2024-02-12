package com.app.service;

import java.util.List;

import com.app.dto.organization.OrgAddDto;
import com.app.dto.organization.OrgAddHeadDto;
import com.app.entities.primary.Organization;

public interface OrganizationService
{
	Organization addOrganization(OrgAddDto org);
	List<Organization> getOrgList();
	Organization addHead(OrgAddHeadDto orgDto);
}
