package com.bitian.security.spring;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class SysUserAuthenticationToken extends AbstractAuthenticationToken {

	private final Object principal;
	private final String password;
	private boolean passValidate;


	public SysUserAuthenticationToken(String username, String password,boolean passValidate) {
		super(null);
		this.principal = username;
		this.password = password;
		this.passValidate=passValidate;
		setAuthenticated(false);
	}

	public SysUserAuthenticationToken(Object principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.password = credentials;
		super.setAuthenticated(true);
	}

	public Object getCredentials() {
		return this.password;
	}

	public Object getPrincipal() {
		return this.principal;
	}

	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	public boolean isPassValidate() {
		return passValidate;
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
	}

}
