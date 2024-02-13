package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.secondary.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Long>{}
