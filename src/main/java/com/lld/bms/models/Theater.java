package com.lld.bms.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
  
  private String name;
  
  @OneToMany
  private List<Auditorium> auditorium;
 
  @Enumerated(EnumType.STRING)
  private TheaterStatus theaterStatus;
  
  @ManyToOne
  private City city;

}
