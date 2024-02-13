package com.app.service;

import java.util.List;

import com.app.dto.schedule.SchedAddDto;
import com.app.entities.secondary.Schedule;

public interface ScheduleService {
	List<Schedule> getSchedList();
	Schedule addSched(Long subId,SchedAddDto schedDto);
}
