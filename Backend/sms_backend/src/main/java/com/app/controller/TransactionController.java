package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;
import com.app.service.TransactionService;
import com.app.util.ResponseText;

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
		return transService.getTransList();
	}
	
	@PostMapping("{feesId}")
	public ResponseEntity<?> addTrans(@PathVariable Long feesId,@RequestBody TransDto transDto)
	{
		Transaction transEnt=transService.addTrans(feesId, transDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
}
