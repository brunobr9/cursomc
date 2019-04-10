package com.brunobr9.cursomc.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;

@Service
public abstract class AbstractService<T extends IdEntity<ID>, ID> implements ServiceInterface<T> {

    @Autowired
    private RepositoryInterface<T, ID> repositoryInterface;

    @Override
    public List<T> findAll() {
	return repositoryInterface.findAll();
    }

    @Override
    public <S extends T> S insert(S object) throws ServiceException {
	object.checkBeforeInsert();
	return repositoryInterface.save(object);
    }

    @Override
    public <S extends T> S update(S object) throws ServiceException {
	object.checkBeforeUpdate();
	return repositoryInterface.save(object);
    }

    @Override
    public void delete(T object) throws ServiceException {
	repositoryInterface.delete(object);
    }
}
