package com.lld.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.lld.bms.dto.TicketRequestDTO;
import com.lld.bms.dto.TicketResponseDTO;
import com.lld.bms.exception.BaseException;
import com.lld.bms.models.Ticket;
import com.lld.bms.service.TicketService;

public class TicketController {
  
  
  @Autowired
  TicketService ticketService;
  
  public TicketResponseDTO bookTicket(TicketRequestDTO ticketRequestDTO) throws BaseException {
      
    Ticket ticket = ticketService.bookTicket(ticketRequestDTO);
    
    TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
    ticketResponseDTO.setTotalAmount(ticket.getAmount());
    ticketResponseDTO.setChairId(ticketRequestDTO.getChairIds());
    ticketResponseDTO.setAuditorium(ticket.getAuditorium());
    ticketResponseDTO.setTicketStatus(ticket.getTicketStatus());
    return ticketResponseDTO;
      
  }
}
