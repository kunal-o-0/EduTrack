package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.primary.Organization;

public interface OrganizationDao extends JpaRepository<Organization, Long>{}
