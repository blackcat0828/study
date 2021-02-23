package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.MemberDetailController;
import controller.RegisterController;
import spring.MemberDao;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private MemberDao memberDao;
	
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public RestMemberController restApi() {
		RestMemberController cont = new RestMemberController();
		cont.setMemberDao(memberDao);
		cont.setRegisterService(memberRegSvc);
		return cont;
	}
}
