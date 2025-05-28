package com.example.commons.exceptions;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorResponse {

	private String message;
	private int status;
	private String error;
	private String path;
	private LocalDateTime tiempo;
	
	public ErrorResponse(String message, int status, String error, String path) {
		this.message = message;
		this.status = status;
		this.error = error;
		this.path = path;
		this.tiempo = LocalDateTime.now(); 
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTiempo() {
		return tiempo;
	}

	public void setTiempo(LocalDateTime tiempo) {
		this.tiempo = tiempo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
