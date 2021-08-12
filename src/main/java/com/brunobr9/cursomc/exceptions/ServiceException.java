package com.brunobr9.cursomc.exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {

	}

	public ServiceException(String mensagem) {
		super(mensagem);
	}
}
