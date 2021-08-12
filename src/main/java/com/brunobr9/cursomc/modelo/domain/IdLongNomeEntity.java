package com.brunobr9.cursomc.modelo.domain;

import com.brunobr9.cursomc.exceptions.ServiceException;

public interface IdLongNomeEntity extends IdEntity<Long> {

	String getNome();

	@Override
	default void checkBeforeInsert() throws ServiceException {
		IdEntity.super.checkBeforeInsert();

		if (getNome() == null) {
			throw new ServiceException("Nome não pode ser nulo!");
		}
	}
}
