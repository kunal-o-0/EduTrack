package com.app.service;

import java.util.List;

import com.app.dto.head.HeadDto;
import com.app.entities.primary.Head;

public interface HeadService {
	List<HeadDto> getHeadList();
	Head addHead(Long orgId, HeadDto headDto);
}
