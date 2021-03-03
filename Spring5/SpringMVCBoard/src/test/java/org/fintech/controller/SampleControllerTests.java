package org.fintech.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.fintech.domain.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//MovkMvc : Tomcat 서버 동작없이 가상서버를 이용하여 url 처리
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class SampleControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConvert() throws Exception {
		
		Ticket ticket = new Ticket();
		
		ticket.setTno(123);
		ticket.setOwner("홍길동");
		ticket.setGrade("S++");
		
		//Ticket 자바객체를 Json형태로 변환처리 
		String jsonStr = new Gson().toJson(ticket);
		
		log.info(jsonStr);
		
		//전송방식 post
		//andExpect : url 처리후 header의 예상되는 상태코드 값
		mockMvc.perform(post("/sample/ticket")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonStr))
						.andExpect(status().is(200));
	
		
	}
	
}





