package com.brunobr9.cursomc.modelo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdLongMapped;
import com.brunobr9.cursomc.modelo.services.IdLongService;

//FIXME: REFATORAR PARA RECEBER DTO E COLOCAR NO ABSTRACT CRUD RESOURCES
public abstract class IdLongResources<T extends IdLongMapped> extends AbstractCrudResources<T, Long> {

    @Autowired
    private IdLongService<T> idLongService;

    // FIXME: REFATORAR PARA DTO
    @Override
    public ResponseEntity<T> insert(@RequestBody T object) throws ServiceException {
	object = idLongService.insert(object /* TODO toEntity(objectDTO) */);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(object.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    // FIXME: REFATORAR PARA DTO
    @Override
    public ResponseEntity<T> update(@RequestBody T object, @PathVariable Long id) throws ServiceException {
	object = idLongService.update(object);
	return null;
    }

}
