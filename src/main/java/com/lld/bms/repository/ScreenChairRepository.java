package com.lld.bms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import com.lld.bms.models.Chair;
import com.lld.bms.models.Screen;
import com.lld.bms.models.ScreenChair;
import jakarta.persistence.LockModeType;

public interface ScreenChairRepository extends JpaRepository<ScreenChair, Long>{
 
  //PESSIMISTIC_WRITE - we have used this lock because we might have to do write operation
  // in table. 
  @Lock(value = LockModeType.PESSIMISTIC_WRITE)
  List<ScreenChair> findAllByChairAndScreen(List<Chair> chair, Screen screen);
}
