package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.attendance.AttendDto;
import com.app.dto.transaction.TransDto;
import com.app.entities.secondary.Transaction;
import com.app.service.TransactionService;
import com.app.util.CreatePayload;
import com.app.util.ResponseText;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TransactionService transService;
	
	@GetMapping
	public ResponseEntity<?> getTransList()
	{
		return  ResponseEntity.status(HttpStatus.OK)
				.body(new CreatePayload<TransDto>("Transaction list",transService.getTransList())); 
	}
	
	@PostMapping
	public ResponseEntity<?> addTrans(@RequestBody TransDto transDto)
	{
		Transaction transEnt=transService.addTrans(transDto.getFeesId(), transDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseText(HttpStatus.CREATED.value(),"Successfully created"));
	}
	
	@PutMapping("/{transId}")
	public ResponseEntity<?> updateTrans(@PathVariable @NotNull Long transId,@RequestBody TransDto transDto)
	{
		Transaction transEnt=transService.updateTrans(transId, transDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully updated"));
	}
	
	@DeleteMapping("/{transId}")
	public ResponseEntity<?> deleteTrans(@PathVariable @NotNull Long transId)
	{
		transService.deleteTrans(transId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseText(HttpStatus.OK.value(),"Successfully deleted"));
	}
}
