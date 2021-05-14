package com.brunobr9.cursomc.modelo.domain;

import java.io.Serializable;

import com.brunobr9.cursomc.exceptions.ServiceException;

public interface IdEntity<T> extends Serializable {

    T getId();

    void setId(T id);

    default void checkBeforeInsert() throws ServiceException {
	if (getId() != null) {
	    throw new ServiceException("Não é possível inserir objeto com id não nulo.");
	}
    }

    default void checkBeforeUpdate() throws ServiceException {
	if (getId() == null) {
	    throw new ServiceException("Não é possível atualizar objeto com id nulo.");
	}
    }

    default void checkBeforeDelete() throws ServiceException {
	if (getId() == null) {
	    throw new ServiceException("Não é possível deletar objeto com id nulo.");
	}
    }
}
