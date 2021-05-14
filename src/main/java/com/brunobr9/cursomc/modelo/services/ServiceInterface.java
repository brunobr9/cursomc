package com.brunobr9.cursomc.modelo.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;

@Service
public interface ServiceInterface<T extends IdEntity<ID>, ID> {

    RepositoryInterface<T, ID> getRepositoryInterface();

    default void processBeforeInsert() {
    }

    default void processBeforeUpdate() {
    }

    default <S extends T> S insert(S object) throws ServiceException {
	object.checkBeforeInsert();
	processBeforeInsert();
	object.setId(null);
	return getRepositoryInterface().save(object);
    }
    
    default void insertAll(Iterable<? extends T> objects) throws ServiceException {
	for (T t : objects) {
	    getRepositoryInterface().save(t);
	}
    }

    default <S extends T> S update(S object) throws ServiceException {
	object.checkBeforeUpdate();
	processBeforeUpdate();
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
