package com.bitian.security.spring;

import com.bitian.common.util.MD5Util;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SysUserAuthenticationProvider implements AuthenticationProvider{

	UserDetailsService customUserDetailsService;

	public SysUserAuthenticationProvider(UserDetailsService userDetailsService){
		this.customUserDetailsService=userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SysUserAuthenticationToken token= (SysUserAuthenticationToken) authentication;
		UserDetails user=customUserDetailsService.loadUserByUsername(token.getName());
		if(!token.isPassValidate() && !MD5Util.md52Hex(authentication.getCredentials().toString()).equals(user.getPassword())){
			throw new BadCredentialsException("密码错误");
		}
	    SysUserAuthenticationToken authenticationResult = new SysUserAuthenticationToken(user,user.getPassword(), user.getAuthorities());
		return authenticationResult;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SysUserAuthenticationToken.class.isAssignableFrom(authentication);
	}


}
