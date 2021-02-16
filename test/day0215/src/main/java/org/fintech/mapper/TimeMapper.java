package org.fintech.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	//dual : 더미(Dummy) 테이블
	//sysdate : 오라클 서버 현재시간
	@Select("select sysdate from dual")
	public String getTime();
	
	//mybatis를 이용해서 현재시간 가져오기
	public String getTime2();
	

}
