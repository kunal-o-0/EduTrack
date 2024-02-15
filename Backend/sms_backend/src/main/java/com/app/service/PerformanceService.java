package com.app.service;

import java.util.List;

import com.app.dto.performance.PerforDto;
import com.app.entities.secondary.Performance;

public interface PerformanceService {
	List<PerforDto> getPerforList();
	Performance addPerfor(Long studId,Long subId,PerforDto perforDto);
	Performance updatePerfor(Long perforId,PerforDto perforDto);
	void deletePerfor(Long perforId);
}
