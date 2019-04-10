package com.brunobr9.cursomc.modelo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.brunobr9.cursomc.exceptions.ServiceException;

//TODO: PARAMETRIZAR PARA DTO
public interface CrudResources<T, ID> {

    String PATH_ID = "/{id}";

    // TODO: PARAMETRIZAR PARA DTO
    ResponseEntity<T> insert(@RequestBody T t) throws ServiceException;

    // TODO: PARAMETRIZAR PARA DTO
    ResponseEntity<T> update(@RequestBody T t, @PathVariable ID id) throws ServiceException;

    // TODO: DEVE RECEBER UM DTO
//    T toEntity(DTO dto);

}
