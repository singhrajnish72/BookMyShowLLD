package com.lld.bms.models;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
  
  private int ticketNo;
  private double amount;
  private LocalTime bookingTime;
  
  @OneToMany
  private List<Chair> bookedChairs;
  
  @ManyToOne
  private Auditorium auditorium;
  
  @ManyToOne
  private User user;
  
  @OneToMany(mappedBy = "ticket")
  private List<Payment> paymentsList;
  
  @Enumerated(EnumType.STRING)
  private TicketStatus ticketStatus;
 
}
