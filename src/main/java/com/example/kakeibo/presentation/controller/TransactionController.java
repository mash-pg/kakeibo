package com.example.kakeibo.presentation.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.example.kakeibo.application.usecase.CreateTransactionUseCase;
import com.example.kakeibo.application.usecase.DeleteTransactionUseCase;
import com.example.kakeibo.application.usecase.GetTransactionUseCase;
import com.example.kakeibo.application.usecase.ListTransactionsUseCase;
import com.example.kakeibo.application.usecase.UpdateTransactionUseCase;
import com.example.kakeibo.domain.entity.Transaction;
import com.example.kakeibo.presentation.dto.CreateTransactionRequest;
import com.example.kakeibo.presentation.dto.TransactionResponse;
import com.example.kakeibo.presentation.dto.UpdateTransactionRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	private final ListTransactionsUseCase listTransactionsUseCase;
	private final UpdateTransactionUseCase updateTransactionUseCase;
	private final DeleteTransactionUseCase deleteTransactionUseCase;
	private final GetTransactionUseCase getTransactionUseCase;
	private final CreateTransactionUseCase createTransactionUseCase;
	
	
	public TransactionController(
			GetTransactionUseCase getTransactionUseCase,
			CreateTransactionUseCase createTransactionUseCase,
			ListTransactionsUseCase listTransactionsUseCase,
			UpdateTransactionUseCase updateTransactionUseCase,
			DeleteTransactionUseCase deleteTransactionUseCase
			) {
		this.getTransactionUseCase = getTransactionUseCase;
		this.createTransactionUseCase = createTransactionUseCase;
		this.listTransactionsUseCase = listTransactionsUseCase;
		this.updateTransactionUseCase = updateTransactionUseCase;
		this.deleteTransactionUseCase = deleteTransactionUseCase;
	}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> create(
			@Valid @RequestBody CreateTransactionRequest request
			){
			Transaction transaction = createTransactionUseCase.execute(
					request.getType(),
					request.getAmount(),
					request.getCategoryId(),
					request.getDescription(),
					request.getTransactionDate()
					);
			
			TransactionResponse response = TransactionResponse.from(transaction);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<TransactionResponse>> list(){
		List<Transaction> transaction = listTransactionsUseCase.execute();
		
		List<TransactionResponse> response = transaction.stream()
									.map(TransactionResponse::from)
									.collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TransactionResponse> detail(
			@PathVariable Long id
			){
		Transaction transaction = getTransactionUseCase.execute(id);
				
		TransactionResponse response = TransactionResponse.from(transaction);
		
		 return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransactionResponse> edit(
			@PathVariable Long id,
			@Valid @RequestBody UpdateTransactionRequest request
			){
		Transaction transaction = updateTransactionUseCase.execute(
					id,
					request.getAmount(),
					request.getType(),
					request.getCategoryId(),
					request.getDescription(),
					request.getTransactionDate()
				);
		TransactionResponse response = TransactionResponse.from(transaction);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		deleteTransactionUseCase.execute(id);
		return ResponseEntity.noContent().build();
		
	}
}
