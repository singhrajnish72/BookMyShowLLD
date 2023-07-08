package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ScreenChairType extends BaseModel {
 
  @ManyToOne
  private Screen screen;
  
  @ManyToOne
  private ChairType chair;
  
  private double ticketPrice;
  
}
