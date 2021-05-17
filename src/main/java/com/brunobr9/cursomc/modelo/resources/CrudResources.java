package com.brunobr9.cursomc.modelo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;

public abstract class CrudResources{
//
//<T extends IdEntityDTO<Long>, U extends IdEntity<Long>>
//	implements ResourcesInterface<T, U> {
////    
////    @Autowired
////    private ServiceInterface<U, Long> serviceInterface;
////    
////    @PostMapping
////    @PermissaoAdmin
////    public ResponseEntity<T> inserir(@Valid @RequestBody T dto) throws ServiceException {
////	U entity = serviceInterface.insert(entityConverter(dto));
////	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(entity.getId()).toUri();
////
////	return ResponseEntity.created(uri).build();
////    }
////
////    @PutMapping(value = PATH_ID)
////    @PermissaoAdmin
////    public ResponseEntity<Void> atualizar(@Valid @RequestBody T dto, @PathVariable Long id) throws ServiceException {
////	dto.setId(id);
////	serviceInterface.update(entityConverter(dto));
////
////	return ResponseEntity.noContent().build();
////    }
////
////    @GetMapping(value = PATH_ID)
////    @PermissaoAdmin
////    public ResponseEntity<T> buscar(@PathVariable Long id) throws ObjectNotFoundException {
////	return ResponseEntity.ok().body(dataObjectConverter(serviceInterface.findById(id)));
////    }
////
////    @GetMapping(path = "/listar")
////    @PermissaoAdmin
////    public ResponseEntity<List<T>> listarTodos() {
////	List<T> lista = serviceInterface.findAll().stream().map(this::dataObjectConverter).collect(Collectors.toList());
////
////	return ResponseEntity.ok().body(lista);
////    }
////
////    @GetMapping(path = "/page")
////    @PermissaoAdmin
////    public ResponseEntity<Page<T>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
////	    @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
////	    @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
////	    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
////
////	Page<U> pageEntity = serviceInterface.findPage(page, linesPerPage, orderBy, direction);
////	Page<T> pageDTO = pageEntity.map(this::dataObjectConverter);
////
////	return ResponseEntity.ok().body(pageDTO);
////    }

}
