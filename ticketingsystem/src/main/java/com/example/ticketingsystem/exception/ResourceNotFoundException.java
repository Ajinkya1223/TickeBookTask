package com.example.ticketingsystem.exception;

public class ResourceNotFoundException extends RuntimeException  {

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
