package com.brunobr9.cursomc.resources;

import java.util.List;

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
import com.brunobr9.cursomc.modelo.resources.ResponseEntityFactory;
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
		return ResponseEntityFactory.created(categoriaService.insert(new Categoria(dto)));
	}

	@Override
	@PermissaoAdmin
	public ResponseEntity<Void> update(@Valid CategoriaDTO dto, Long id) throws ServiceException {
		categoriaService.update(new Categoria(dto, id));
		return ResponseEntityFactory.noContent();
	}

	@Override
	@PermissaoAdmin
	public ResponseEntity<CategoriaDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
		return ResponseEntityFactory.find(categoriaService.findById(id), CategoriaDTO::new);
	}

	@Override
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		return ResponseEntityFactory.list(categoriaService.findAll(), CategoriaDTO::new);
	}

}
