package com.example.exceptions.list;

public class InvalidDataException extends RuntimeException {
	public InvalidDataException(String msg) {
		super(msg);
	}
}
