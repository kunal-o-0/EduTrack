package com.app.service;

import java.util.List;

import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;

public interface TransactionService {
	List<Transaction> getTransList();
	Transaction addTrans(Long feesId,TransDto transDto);
}
