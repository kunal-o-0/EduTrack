package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<TransDto> getTransList() {
		return transDao.findAll()
						.stream()
						.map((transEnt)->
											{
												TransDto transDto=mapper.map(transEnt, TransDto.class);
												transDto.setFeesId(transEnt.getFees().getFeesId());
												return transDto;
											})
						.collect(Collectors.toList());
	}
	
	@Override
	public Transaction addTrans(Long feesId, TransDto transDto) {
		Transaction transEnt=mapper.map(transDto, Transaction.class);
		transEnt.setFees(feesDao.findById(feesId).orElseThrow());
		return transDao.save(transEnt);
	}

	@Override
	public Transaction updateTrans(Long transId, TransDto transDto) {
		Transaction transOld=transDao.findById(transId).orElseThrow();
		Transaction transNew=mapper.map(transDto, Transaction.class);
		transNew.setTransId(transOld.getTransId());
		transNew.setFees(transOld.getFees());
		return transDao.save(transNew);
	}

	@Override
	public void deleteTrans(Long transId) {
		// TODO Auto-generated method stub
		
	}	
}
