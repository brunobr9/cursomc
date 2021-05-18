package com.brunobr9.cursomc.modelo.resources;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.brunobr9.cursomc.exceptions.ServiceException;

public interface ApiCrudResources<T> {

    String PATH_ID = "/{id}";

    String LISTAR = "listar";
    String PAGE = "page";

    @PostMapping
    ResponseEntity<T> insert(@Valid @RequestBody T dto) throws ServiceException;

    @PutMapping(value = PATH_ID)
    ResponseEntity<Void> update(@Valid @RequestBody T dto, @PathVariable Long id) throws ServiceException;

    @GetMapping(value = PATH_ID)
    ResponseEntity<T> find(@PathVariable Long id) throws ObjectNotFoundException, ServiceException;

    @GetMapping(value = LISTAR)
    ResponseEntity<List<T>> findAll();

}
