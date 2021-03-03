package org.fintech.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt; //게시물에 대한 댓글 갯수
	private List<ReplyVO> list; //댓글 리스트
	
	
}
