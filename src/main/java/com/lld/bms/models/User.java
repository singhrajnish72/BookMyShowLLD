package com.lld.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel{
 
  private String userName;
  private int age;
  private String userAddress;
  private String email;
}
