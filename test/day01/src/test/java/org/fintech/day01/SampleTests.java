package org.fintech.day01;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


//스프링 테스트시 선언
@RunWith(SpringJUnit4ClassRunner.class)
//root-context.xml의 위치 설정

//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링에서 객체로 등록시키기 위함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //콘솔창에 로그를 출력
public class SampleTests {

	//Restaurant 클래스를 DI(의존적 주입)를 하면서
	//@Setter를 이용하여 setRestaurant() 메서드를 컴파일시 추가시킨다.
	@Setter(onMethod_= @Autowired)
	private Restaurant restaurant;
	
	//새로운 인스턴스가 생성되며 독립적인 테스트를 진행
	@Test
	public void testExist() {
		
		//Restaurant 객체가 생성되어 있으면 성공이고
		//Restaurant 객체가 생성되어 있지 않으면 실패
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------");
		log.info(restaurant.getChef());
	}
	
}




