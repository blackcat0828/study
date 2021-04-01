package org.hdcd.common.security.domain;

import java.util.Collection;

public class AuthenticationToken {

	private String username;
	private Collection authorities;
	private String token;

	public AuthenticationToken(String username, Collection collection, String token) {
		this.username = username;
		this.authorities = collection;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection authorities) {
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

}
