package org.hdcd.common.security;

import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.dto.Member;
import org.hdcd.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Load User By UserName: " + email);
		
		//userName은 사용자명이 아니라 사용자 아이디를 의미한다.
		Member member = memberMapper.read(email);
		log.info("쿼리가 넘어오나? 성공?");
		log.info("queried by member mapper: " + member);

		return member == null ? null : new CustomUser(member);
	}
	
}
