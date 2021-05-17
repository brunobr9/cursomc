package com.brunobr9.cursomc.modelo.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApiResources<T> {

    public static final String PATH_ID = "/{id}";

    public static final String LISTAR = "listar";
    public static final String PAGE = "page";

    @PostMapping
    ResponseEntity<T> insert(@Valid @RequestBody T dto);

    @PutMapping(value = PATH_ID)
    ResponseEntity<Void> update(@Valid @RequestBody T dto, @PathVariable Long id);

    @GetMapping(value = PATH_ID)
    ResponseEntity<T> find(@PathVariable Long id);

    @GetMapping(value = LISTAR)
    ResponseEntity<List<T>> findAll();

//    String PATH_ID = "/{id}";
//
//    String LISTAR = "/listar";
//    String PAGE = "/page";
//
//    ServiceInterface<U, Long> getService();
//
//    U entityConverter(T dto);
//
//    T dataObjectConverter(U entity);
//
//    @PostMapping
//    @PermissaoAdmin
//    default ResponseEntity<T> insert(@Valid @RequestBody T dto) throws ServiceException {
//	U entity = getService().insert(entityConverter(dto));
//	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(entity.getId()).toUri();
//
//	return ResponseEntity.created(uri).build();
//    }
//
//    @PutMapping(value = PATH_ID)
//    @PermissaoAdmin
//    default ResponseEntity<Void> update(@Valid @RequestBody T dto, @PathVariable Long id) throws ServiceException {
//	dto.setId(id);
//	getService().update(entityConverter(dto));
//
//	return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping(value = PATH_ID)
//    @PermissaoAdmin
//    default ResponseEntity<T> find(@PathVariable Long id) throws ObjectNotFoundException, ServiceException {
//	return ResponseEntity.ok().body(dataObjectConverter(getService().findById(id)));
//    }
//
//    @GetMapping(path = LISTAR)
//    @PermissaoAdmin
//    default ResponseEntity<List<T>> findAll() {
//	List<T> lista = getService().findAll().stream().map(this::dataObjectConverter).collect(Collectors.toList());
//
//	return ResponseEntity.ok().body(lista);
//    }
//
//    @GetMapping(path = PAGE)
//    @PermissaoAdmin
//    default ResponseEntity<Page<T>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
//	    @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
//	    @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
//	    @RequestParam(value = "direction", defaultValue = "ASC") String direction)
//	    throws ObjectNotFoundException, ServiceException {
//
//	Page<U> pageEntity = getService().findAllPage(page, linesPerPage, orderBy, direction);
//	Page<T> pageDTO = pageEntity.map(this::dataObjectConverter);
//
//	return ResponseEntity.ok().body(pageDTO);
//    }

}
