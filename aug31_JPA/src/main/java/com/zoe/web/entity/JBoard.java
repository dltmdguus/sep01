package com.zoe.web.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class JBoard {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int bno;
	
	@Column(name="btitle", length = 15)
	private String title;
	
	@Column(name="bcontent", columnDefinition = "MEDIUMTEXT")
	private String content;
	
	@LastModifiedDate //수정된다면, 마지막 수정시간으로 바꿔주는 것
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime bdate;
	
	
	@ManyToOne(fetch = FetchType.LAZY) //지연로딩
	@JoinColumn(name="mno")
	private Member member; //객체로 저장
	

}
