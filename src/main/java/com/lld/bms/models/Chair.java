package com.lld.bms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chair extends BaseModel{
  
  private String chairNo;
  
  @Column(name = "rowz")
  private int rows;
  
  @Column(name = "colz")
  private int cols;
  
  @ManyToOne
  private ChairType chairType;

}
