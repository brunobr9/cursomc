package com.brunobr9.cursomc.modelo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.exceptions.ServiceException;

@Service
public interface ServiceInterface<T> {

    <S extends T> S insert(S object) throws ServiceException;

    <S extends T> S update(S object) throws ServiceException;

    void delete(T object) throws ServiceException;

    List<T> findAll();

}
