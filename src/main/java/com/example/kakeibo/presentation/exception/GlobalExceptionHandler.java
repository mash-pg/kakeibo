package com.example.kakeibo.presentation.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kakeibo.domain.exception.CategoryInUseException;
import com.example.kakeibo.domain.exception.CategoryNotFoundException;
import com.example.kakeibo.domain.exception.InvalidAmountException;
import com.example.kakeibo.domain.exception.InvalidCategoryException;
import com.example.kakeibo.domain.exception.TransactionNotFoundException;
import com.example.kakeibo.presentation.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
		//404
		@ExceptionHandler(TransactionNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleNotFound(TransactionNotFoundException e){
			ErrorResponse error = new ErrorResponse("Not Found",e.getMessage());
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		//404
		@ExceptionHandler(CategoryNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleConflict(CategoryNotFoundException e){
			ErrorResponse error = new ErrorResponse("Not Found",e.getMessage());
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		
		//409
		@ExceptionHandler(CategoryInUseException.class)
		public ResponseEntity<ErrorResponse> handleConflict(CategoryInUseException e){
			ErrorResponse error = new ErrorResponse("Conflict",e.getMessage());
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		}
		//400
		@ExceptionHandler(InvalidAmountException.class)
		public ResponseEntity<ErrorResponse> handleValidation(InvalidAmountException e){
          	ErrorResponse error = new ErrorResponse("Bad Request", e.getMessage());
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.badRequest().body(error);		

		}
		//400
		@ExceptionHandler(InvalidCategoryException.class)
		public ResponseEntity<ErrorResponse> handleValidation(InvalidCategoryException e){
          	ErrorResponse error = new ErrorResponse("Bad Request", e.getMessage());
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.badRequest().body(error);		

		}
		//400
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e){
			
          String message = e.getBindingResult().getFieldErrors().stream()
                  .map(error -> error.getField() + ": " + error.getDefaultMessage())
                  .collect(Collectors.joining(", "));
          	ErrorResponse error = new ErrorResponse("Bad Request", message);
			log.error("Exception occurred : {}",e.getMessage());
			return ResponseEntity.badRequest().body(error);		

		}

}
