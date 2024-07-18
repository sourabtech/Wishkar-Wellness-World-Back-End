package com.project.exception;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException(String message)
	{
		super(message);
	}
}
