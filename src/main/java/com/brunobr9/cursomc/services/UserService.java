package com.brunobr9.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.brunobr9.cursomc.security.UserSS;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    public static UserSS authenticated() {
	try {
	    return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	} catch (Exception e) {
	    return null;
	}
    }
}
