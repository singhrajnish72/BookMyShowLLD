package com.lld.bms.models;

import java.util.List;
import jakarta.persistence.ElementCollection;
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
public class Auditorium extends BaseModel{
  
  private String auditoriumName;
  
  @OneToMany
  private List<Chair> chairs;
  
  @ElementCollection
  private List<FeatureTypes> features;
  
}
