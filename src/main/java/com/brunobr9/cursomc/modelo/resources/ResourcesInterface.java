package com.brunobr9.cursomc.modelo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunobr9.cursomc.dto.IdEntityDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;

public interface ResourcesInterface<T extends IdEntityDTO<Long>, U extends IdEntity<Long>> {

    String PATH_ID = "/{id}";

    String LISTAR = "/listar";
    String PAGE = "/page";

    ServiceInterface<U, Long> getService();

    U entityConverter(T dto);

    T dataObjectConverter(U entity);

    @PostMapping
    default ResponseEntity<T> insert(@Valid @RequestBody T dto) throws ServiceException {
	U entity = getService().insert(entityConverter(dto));
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(entity.getId()).toUri();

	return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = PATH_ID)
    default ResponseEntity<Void> update(@Valid @RequestBody T dto, @PathVariable Long id) throws ServiceException {
	dto.setId(id);
	getService().update(entityConverter(dto));

	return ResponseEntity.noContent().build();
    }

    @GetMapping(value = PATH_ID)
    default ResponseEntity<T> find(@PathVariable Long id) throws ObjectNotFoundException, ServiceException {
	return ResponseEntity.ok().body(dataObjectConverter(getService().findById(id)));
    }

    @GetMapping(path = LISTAR)
    default ResponseEntity<List<T>> findAll() {
	List<T> lista = getService().findAll().stream().map(this::dataObjectConverter).collect(Collectors.toList());

	return ResponseEntity.ok().body(lista);
    }

    @GetMapping(path = PAGE)
    default ResponseEntity<Page<T>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
	    @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
	    @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
	    @RequestParam(value = "direction", defaultValue = "ASC") String direction)
	    throws ObjectNotFoundException, ServiceException {

	Page<U> pageEntity = getService().findAllPage(page, linesPerPage, orderBy, direction);
	Page<T> pageDTO = pageEntity.map(this::dataObjectConverter);

	return ResponseEntity.ok().body(pageDTO);
    }

}
