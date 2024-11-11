package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
@Entity(name="reactcomment")
@Data
public class CommentEntity {
	@Id
    private int no;
	private int fno;
    private String id;
    private String name;
    private String msg;
    private String sex;
    
    @Column(insertable = true , updatable = false)
    private String regdate;
   
    @PrePersist
    public void regdate() {
    	this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
    }
}
