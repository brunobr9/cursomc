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

    default void processBeforeInsert(T object) throws ServiceException {
	object.checkBeforeInsert();
    }

    default void processBeforeUpdate(T object) throws ServiceException {
	object.checkBeforeUpdate();
    }

    default T insert(T object) throws ServiceException {
	processBeforeInsert(object);
	object.setId(null);
	return getRepositoryInterface().save(object);
    }

    default void insertAll(Iterable<? extends T> objects) throws ServiceException {
	for (T t : objects) {
	    getRepositoryInterface().save(t);
	}
    }

    default T update(T object) throws ServiceException {
	processBeforeUpdate(object);
	return getRepositoryInterface().save(object);
    }

    default void delete(T object) throws ServiceException {
	object.checkBeforeDelete();
	getRepositoryInterface().deleteById(object.getId());
    }

    default List<T> findAll() {
	return getRepositoryInterface().findAll();
    }

    default T findById(ID id) throws ObjectNotFoundException {
	Optional<T> obj = getRepositoryInterface().findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException((Serializable) id, this.getClass().getName()));
    }

    default Page<T> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
	return getRepositoryInterface()
		.findAll(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
    }

}
