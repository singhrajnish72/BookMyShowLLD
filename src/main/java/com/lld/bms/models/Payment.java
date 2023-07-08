package com.lld.bms.models;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    
  private String referenceId;
  
  private double amount;
  
  private Date bookingTime;
  
  @Enumerated(EnumType.STRING)
  private PaymentMode paymentMode;
  
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;
    
  @ManyToOne
  private Ticket ticket;
}
