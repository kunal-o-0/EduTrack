package com.app.service;

import java.util.List;

import com.app.dto.schedule.SchedDto;
import com.app.entities.secondary.Schedule;

public interface ScheduleService {
	List<SchedDto> getSchedList();
	Schedule addSched(Long subId,SchedDto schedDto);
}
