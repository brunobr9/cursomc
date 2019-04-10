package com.brunobr9.cursomc.modelo.domain;

import java.io.Serializable;

import com.brunobr9.cursomc.exceptions.ServiceException;

public interface IdEntity<ID> extends Serializable {

    ID getId();

    void checkBeforeInsert() throws ServiceException;

    void checkBeforeUpdate() throws ServiceException;

    void checkBeforeDelete() throws ServiceException;

}
