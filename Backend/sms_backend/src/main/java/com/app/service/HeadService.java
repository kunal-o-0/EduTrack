package com.app.service;

import java.util.List;

import com.app.dto.head.HeadDto;
import com.app.entities.primary.Head;

public interface HeadService {
	List<Head> getHeadList();
	Head addHead(Long orgId, HeadDto headDto);
}
