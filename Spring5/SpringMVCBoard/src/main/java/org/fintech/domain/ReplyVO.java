package org.fintech.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//댓글테이블
@Data
public class ReplyVO {

	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	private Date replydate;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	private Date updatedate;
}




