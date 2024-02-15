package com.app.service;

import java.util.List;

import com.app.dto.organization.OrgDto;
import com.app.dto.organization.OrgAddHeadDto;
import com.app.entities.primary.Organization;

public interface OrganizationService
{
	Organization addOrganization(OrgDto orgDto);
	List<OrgDto> getOrgList();
	Organization addHead(OrgAddHeadDto orgDto);
	Organization updateOrg(Long orgId,OrgDto orgDto);
	void deleteOrg(Long orgId);
}
