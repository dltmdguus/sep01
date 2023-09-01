package com.zoe.web.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
//영속성
@Entity
@Data //롬복에서 데이터, get/set, to String
@Table(name = "jmember")
@NoArgsConstructor //생성자 만들지 마
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mno;
	
	@Column(length = 10)
	private String mname;
	
	@Column(name="mid", unique = true)
	private String mid;
	
	@Column(name="mpw", nullable = false)
	private String mpw;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDate mjoindate;

}

