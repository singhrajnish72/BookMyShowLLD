package com.lld.bms.models;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
   
  private Date entryTime;
  private Date exitTime;
  
  @ManyToOne
  private Auditorium auditorium;
  
  private String movieName;
  private String language;
}
