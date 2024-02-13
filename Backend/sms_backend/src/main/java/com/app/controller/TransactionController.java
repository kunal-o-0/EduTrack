package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;
import com.app.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TransactionService transService;
	
	@GetMapping
	public List<TransDto> getTransList()
	{
		return transService.getTransList()
							.stream()
							.map((transEnt)->
												{
													TransDto transDto=mapper.map(transEnt, TransDto.class);
													transDto.setFeesId(transEnt.getFees().getFeesId());
													return transDto;
												})
							.collect(Collectors.toList());
	}
	
	@PostMapping("{feesId}")
	public void addTrans(@PathVariable Long feesId,@RequestBody TransDto transDto)
	{
		Transaction transEnt=transService.addTrans(feesId, transDto);
	}
}
