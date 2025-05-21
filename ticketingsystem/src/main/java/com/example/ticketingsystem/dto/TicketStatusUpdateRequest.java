package com.example.ticketingsystem.dto;

import com.example.ticketingsystem.entity.Ticket.Status;


public class TicketStatusUpdateRequest {

	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
