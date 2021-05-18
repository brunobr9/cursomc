package com.brunobr9.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.dto.CategoriaDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ApiCrudResources;
import com.brunobr9.cursomc.modelo.resources.ResponseFactory;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource implements ApiCrudResources<CategoriaDTO> {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    @PermissaoAdmin
    public ResponseEntity<CategoriaDTO> insert(@Valid CategoriaDTO dto) throws ServiceException {
	return new ResponseFactory<CategoriaDTO>().create(categoriaService.insert(new Categoria(dto)).getId());
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<Void> update(@Valid CategoriaDTO dto, Long id) throws ServiceException {
	dto.setId(id);
	categoriaService.update(new Categoria(dto));
	return ResponseFactory.create();
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<CategoriaDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
	return ResponseEntity.ok().body(new CategoriaDTO(categoriaService.findById(id)));
    }

    @Override
    public ResponseEntity<List<CategoriaDTO>> findAll() {
	return ResponseEntity.ok()
		.body(categoriaService.findAll().stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList()));
    }

}
