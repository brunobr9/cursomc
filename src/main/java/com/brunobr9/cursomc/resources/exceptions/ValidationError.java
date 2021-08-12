package com.brunobr9.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();

	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}

	public ValidationError(int codigo, String msg, Long timeStamp) {
		super(codigo, msg, timeStamp);
	}
}
