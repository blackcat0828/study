package org.hdcd.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.java.Log;

//SavedRequestAwareAuthenticationSuccessHandler는 AuthenticationSuccessHandler의
//구현 클래스이다. 인증 전에 접근을 시도한 URL로 리다이렉트 하는 기능을 가지고 있으며 스프링 시큐리티에서 기본적으로
//사용되는 구현 클래스이다.

@Log
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication auth) throws IOException, ServletException {
		log.info("onAuthenticationSuccess");
		
		User customUser = (User)auth.getPrincipal();
		
		log.info("useranme = " + customUser.getUsername());
		
		super.onAuthenticationSuccess(request, response, auth);
	}

}
