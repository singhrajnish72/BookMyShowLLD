package com.lld.bms.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDTO {
  
  private Long userId;
  private Long screenId;
  private List<Long> chairIds;
 
}
