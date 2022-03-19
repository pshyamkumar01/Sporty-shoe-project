package com.shyam.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public class DateAndTime {

	@CreatedDate
    @Column(name = "DATE_CREATED", columnDefinition = "DATE")
    protected Date createdDate;
    
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate( Date createdDate) {
        this.createdDate = new Date();
    }
    
}
