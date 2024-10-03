package com.example.exceptions.list;

public class BadRequestException extends Exception{
	public BadRequestException(String msg){
		super(msg);
	}
}
