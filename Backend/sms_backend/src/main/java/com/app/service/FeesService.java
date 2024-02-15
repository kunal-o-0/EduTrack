package com.app.service;

import java.util.List;

import com.app.dto.fees.FeesDto;
import com.app.entities.secondary.Fees;

public interface FeesService {
	List<FeesDto> getFeesList();
	Fees addFees(Long studId,FeesDto feesDto);
	Fees updateFees(Long feesId,FeesDto feesDto);
	void deleteFees(Long feesId);
}
