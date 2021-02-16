package org.fintech.persistence;

import org.fintech.mapper.TimeMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //콘솔창에 로그 표시
public class TimeMapperTests {

	@Setter(onMethod_ = @Autowired) //DI(의존적 주입)
	private TimeMapper timeMapper;
	
	@Ignore //mybatis 를 사용 안하고 처리
	public void testGetTime() {
		//현재 테스트중인 클래스 이름
		log.info(timeMapper.getClass().getName());
		//TimeMapper interface 의 getTime() 메서드 리턴값 
		log.info(timeMapper.getTime());
	}
	
	//mybatis를 활용한 현재시간 출력
	@Test
	public void testGetTime2() {
		log.info("getTime2() 실행");
		log.info(timeMapper.getTime2());
	}
	
	
}




