package com.example.commons.exceptions;

public class StockInsuficienteException extends RuntimeException {

	public StockInsuficienteException (String mensaje) {
		super(mensaje);
	}
}
