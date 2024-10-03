package com.example.exceptions.list;

public class InternalServerErrorException extends RuntimeException {

	public InternalServerErrorException(String message) {
		super(message);
	}
}