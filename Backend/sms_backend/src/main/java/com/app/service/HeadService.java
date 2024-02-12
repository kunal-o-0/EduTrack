package com.app.service;

import java.util.List;

import com.app.dto.head.HeadAddDto;
import com.app.entities.primary.Head;

public interface HeadService {
	List<Head> getHeadList();
	Head addHead(Long orgId, HeadAddDto headDto);
}
