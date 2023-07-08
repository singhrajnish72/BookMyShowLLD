package com.lld.bms.dto;

import java.util.List;
import com.lld.bms.models.Auditorium;
import com.lld.bms.models.Screen;
import com.lld.bms.models.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {
  
  private List<Long> chairId;
  private Auditorium auditorium;
  private double totalAmount;
  private TicketStatus ticketStatus;
   
}
