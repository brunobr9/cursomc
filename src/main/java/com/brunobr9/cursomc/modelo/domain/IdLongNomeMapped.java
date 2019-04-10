package com.brunobr9.cursomc.modelo.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.brunobr9.cursomc.exceptions.ServiceException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class IdLongNomeMapped extends IdLongMapped {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String nome;

    @Override
    public void checkBeforeInsert() throws ServiceException {
	if (nome == null) {
	    throw new ServiceException("Nome não pode ser nulo!");
	}
	super.checkBeforeInsert();
    }
}
