package com.app.service;

import java.util.List;

import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;

public interface TransactionService {
	List<TransDto> getTransList();
	Transaction addTrans(Long feesId,TransDto transDto);
	Transaction updateTrans(Long transId,TransDto transDto);
	void deleteTrans(Long transId);
}
