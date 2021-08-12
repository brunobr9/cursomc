package com.brunobr9.cursomc.exceptions;

public class AuthorizationException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String mensagem) {
		super(mensagem);
	}
}
