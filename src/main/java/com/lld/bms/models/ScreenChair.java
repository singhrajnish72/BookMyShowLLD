package com.lld.bms.models;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ScreenChair extends BaseModel{
   
  @ManyToOne
  private Screen screen;
  
  @ManyToOne
  private Chair chair;
  
  @Enumerated(EnumType.STRING)
  private ChairStatus chairStatus;
  
  private LocalTime lockedAt;

}
