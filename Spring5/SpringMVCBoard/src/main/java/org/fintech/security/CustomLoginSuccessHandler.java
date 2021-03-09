package org.fintech.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//클라이언트 ROLE을 담기위한 LIST 선언
		List<String> roleNames = new ArrayList<>();
		
		//getAuthorities()?
		//사용자 계정이 가지고 있는 권한(ROLE)목록을 가져오는 메서드
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
			
		});
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MANAGER")){
			response.sendRedirect("/sample/member");
			return;
		}
		
		response.sendRedirect("/board/list");
	}
	
}