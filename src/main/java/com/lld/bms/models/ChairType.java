package com.lld.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChairType extends BaseModel{
    
  private String chairType;
}
