package com.brunobr9.cursomc.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;

//@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRES_NEW)
public abstract class CrudService<T extends IdEntity<ID>, ID> {

//    @Autowired
//    private RepositoryInterface<T, ID> repo;
//
//    public T insert(T object) throws ServiceException {
//	return repo.save(object);
//    }
//    
    //TODO update
    
    //TODO delete
    
    //TODO findAll

}
