package com.lld.bms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lld.bms.models.Chair;
import com.lld.bms.models.ScreenChairType;

public interface ScreenChairTypeRepository extends JpaRepository<ScreenChairType, Long>{

  List<ScreenChairType> findScreenChairType(Long screenId, List<Chair> chairs);

}
