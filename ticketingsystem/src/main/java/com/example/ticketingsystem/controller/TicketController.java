package com.example.ticketingsystem.controller;


import com.example.ticketingsystem.dto.TicketStatusUpdateRequest;
import com.example.ticketingsystem.entity.Ticket;
import com.example.ticketingsystem.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    // POST /tickets → Create new support ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        Ticket created = ticketService.createTicket(ticket);
        return ResponseEntity.ok(created);
    }

    // GET /tickets → Get all tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // GET /tickets/{id} → Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    // PUT /tickets/{id}/status → Update ticket status
    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateTicketStatus(
            @PathVariable Long id,
            @RequestBody TicketStatusUpdateRequest statusUpdateRequest) {
        Ticket updated = ticketService.updateTicketStatus(id, statusUpdateRequest.getStatus());
        return ResponseEntity.ok(updated);
    }
    
}
