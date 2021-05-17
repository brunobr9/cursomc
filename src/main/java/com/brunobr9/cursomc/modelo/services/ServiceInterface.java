package com.brunobr9.cursomc.modelo.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;

@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRES_NEW)
public interface ServiceInterface<T extends IdEntity<ID>, ID> {

    RepositoryInterface<T, ID> getRepositoryInterface();

    default T processBeforeInsert(T object) throws ServiceException {
	return object;
    }

    default T processBeforeUpdate(T object) throws ServiceException {
	return object;
    }

    default T insert(T object) throws ServiceException {
	T objectToInsert = processBeforeInsert(object);
	objectToInsert.setId(null);
	return getRepositoryInterface().save(objectToInsert);
    }

    default void insertAll(Iterable<? extends T> objects) throws ServiceException {
	for (T t : objects) {
	    getRepositoryInterface().save(t);
	}
    }

    default T update(T object) throws ServiceException {
	object.checkBeforeUpdate();
	return getRepositoryInterface().save(processBeforeUpdate(object));
    }

    default void delete(T object) throws ServiceException {
	object.checkBeforeDelete();
	getRepositoryInterface().deleteById(object.getId());
    }

    default List<T> findAll() {
	return getRepositoryInterface().findAll();
    }

    default T findById(ID id) throws ObjectNotFoundException, ServiceException {
	Optional<T> obj = getRepositoryInterface().findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException((Serializable) id, this.getClass().getName()));
    }

    default Page<T> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
	return getRepositoryInterface()
		.findAll(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
    }

}
