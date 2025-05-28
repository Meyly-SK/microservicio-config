package com.example.commons.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sun.net.httpserver.HttpServer;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	public GlobalExceptionHandler() {
	    System.out.println("✅ GlobalExceptionHandler cargado correctamente");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest request){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errors.put(error.getField(), error.getDefaultMessage())
		);
		
		ErrorResponse errorResponse = new ErrorResponse(
				"Validacion fallida",
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(),
				request.getRequestURI());
		
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(EntityNotFoundException ex, HttpServletRequest request){
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomNotFound(NotFoundException ex, HttpServletRequest request){
		System.out.println("🔥 Capturado NotFoundException");
	    ErrorResponse errorResponse = new ErrorResponse(
	    		ex.getMessage(),
	    		HttpStatus.NOT_FOUND.value(),
	    		HttpStatus.NOT_FOUND.getReasonPhrase(),
	    		request.getRequestURI()
	    		);
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex, HttpServletRequest request){
		ErrorResponse errorResponse = new ErrorResponse(
				"Violacion de restriccion en la base de datos : " + ex.getMostSpecificCause().getMessage(),
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(),
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 400, "Bad Request", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(StockInsuficienteException.class)
	public ResponseEntity<ErrorResponse> handleStock(StockInsuficienteException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 400, "Bad Request", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ReporteExcelException.class)
	public ResponseEntity<ErrorResponse> handleExcel (ReporteExcelException ex, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 500, "Error en la generacio de documento ", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request){
		ErrorResponse errorResponse = new ErrorResponse
				("Error interno del servidor",
				 HttpStatus.INTERNAL_SERVER_ERROR.value(),
				 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				 request.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
	
	
	
}
