package com.brunobr9.cursomc.modelo.services;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;

public interface CrudService<T extends IdEntity<ID>, ID> {

	T insert(T object) throws ServiceException;

	T update(T object) throws ServiceException;

	void delete(T object) throws ServiceException;

	void insertAll(Iterable<? extends T> objects) throws ServiceException;

	T findById(ID id) throws ObjectNotFoundException, ServiceException;

	List<T> findAll();

	Page<T> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction);
}
