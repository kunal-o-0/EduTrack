package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FeesDao;
import com.app.dao.TransactionDao;
import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;
import com.app.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TransactionDao transDao;
	@Autowired
	private FeesDao feesDao;
	
	@Override
	public List<Transaction> getTransList() {
		return transDao.findAll();
	}
	@Override
	public Transaction addTrans(Long feesId, TransDto transDto) {
		Transaction transEnt=mapper.map(transDto, Transaction.class);
		transEnt.setFees(feesDao.findById(feesId).orElseThrow());
		return transDao.save(transEnt);
	}	
}
