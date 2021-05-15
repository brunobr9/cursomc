package com.brunobr9.cursomc.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AttemptAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public AttemptAuthenticationException(String mensagem) {
	super(mensagem);
    }
}
