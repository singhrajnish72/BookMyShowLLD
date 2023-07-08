package com.lld.bms.models;

import java.sql.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // Don't create a sep table, instead put its attributes to every child
public class BaseModel {
    
    @Id
    private Long id;
    
    @CreatedDate
    private Date createdDate;
}
