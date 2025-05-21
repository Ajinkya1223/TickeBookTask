package com.example.ticketingsystem.service;




import com.example.ticketingsystem.entity.Ticket;
import com.example.ticketingsystem.entity.Ticket.Status;
import com.example.ticketingsystem.exception.ResourceNotFoundException;
import com.example.ticketingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

	 @Autowired
	    private TicketRepository ticketRepository;

	    // Create new ticket
	    public Ticket createTicket(Ticket ticket) {
	        ticket.setStatus(Status.OPEN);
	        return ticketRepository.save(ticket);
	    }

	    // Get all tickets
	    public List<Ticket> getAllTickets() {
	        return ticketRepository.findAll();
	    }

	    // Get ticket by ID
	    public Ticket getTicketById(Long id) {
	        return ticketRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
	    }

	    // Update ticket status (simulate admin)
	    public Ticket updateTicketStatus(Long id, Status newStatus) {
	        Ticket ticket = getTicketById(id);
	        ticket.setStatus(newStatus);
	        return ticketRepository.save(ticket);
	    }
}
