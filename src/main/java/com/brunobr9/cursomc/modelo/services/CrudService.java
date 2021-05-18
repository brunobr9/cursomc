package com.brunobr9.cursomc.modelo.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;

@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRES_NEW)
public abstract class CrudService<T extends IdEntity<ID>, ID> implements ServiceInterface<T, ID> {

    @Autowired
    private RepositoryInterface<T, ID> repositoryInterface;

    protected T processBeforeInsert(T object) throws ServiceException {
	return object;
    }

    protected T processBeforeUpdate(T object) throws ServiceException {
	return object;
    }

    @Override
    public T insert(T object) throws ServiceException {
	T objectToInsert = processBeforeInsert(object);
	objectToInsert.setId(null);
	return repositoryInterface.save(objectToInsert);
    }

    @Override
    public void insertAll(Iterable<? extends T> objects) throws ServiceException {
	for (T t : objects) {
	    repositoryInterface.save(t);
	}
    }

    @Override
    public T update(T object) throws ServiceException {
	object.checkBeforeUpdate();
	return repositoryInterface.save(processBeforeUpdate(object));
    }

    @Override
    public void delete(T object) throws ServiceException {
	object.checkBeforeDelete();
	repositoryInterface.deleteById(object.getId());
    }

    @Override
    public List<T> findAll() {
	return repositoryInterface.findAll();
    }

    @Override
    public T findById(ID id) throws ObjectNotFoundException, ServiceException {
	Optional<T> obj = repositoryInterface.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException((Serializable) id, this.getClass().getName()));
    }

    public Page<T> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
	return repositoryInterface.findAll(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
    }

}
