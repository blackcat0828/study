package org.fintech.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
						})

@Log4j
//Controller 및 Web 환경에 사용되는 Bean등을 자동으로 생성하여 등록시킨다.
@WebAppConfiguration
public class BoardControllerTests {
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//MockMvcBuilders?
	//요청 데이터를 설정할 때 사용하는 static 메서드
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		//mockMvc.perform()?
		//MockMvc를 실행한다.
		//get : 전송방식
		//get(실행하려는 url 지정)
		//andReturn() : 테스트한 결과를 객체형태로 리턴받는다.
		//getModelAndView() : Model 객체의 값과 View에 저장된 값을 확인
		//getModelMap() : Model 객체의 값을 Map형태로 확인
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}
	
	@Ignore
	public void testRegister() throws Exception {
		log.info("로그테스트1231231");
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "주문배송")
					.param("contents","빠른배송 부탁합니다.")
					.param("writer","홍길동")
				).andReturn().getModelAndView().getViewName();
		
		log.info("로그테스트@@@@@@@@@@@@@"+resultPage);
	}
}
