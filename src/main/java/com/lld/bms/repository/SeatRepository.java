package com.lld.bms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lld.bms.models.Chair;

public interface SeatRepository extends JpaRepository<Chair, Long>{
      
   List<Chair> findAllById(List<Long> ids);
}