package com.app.service;

import java.util.List;

import com.app.dto.OrgAddDto;
import com.app.entities.primary.Organization;

public interface OrganizationService
{
	Organization addOrganization(OrgAddDto org);
	List<Organization> getOrgList();
}
