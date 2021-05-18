package com.brunobr9.cursomc.resources;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Estado;
import com.brunobr9.cursomc.dto.EstadoDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ApiCrudResources;
import com.brunobr9.cursomc.modelo.resources.ResponseEntityFactory;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoResource implements ApiCrudResources<EstadoDTO> {

	@Autowired
	private EstadoService estadoService;

	@Override
	@PermissaoAdmin
	public ResponseEntity<EstadoDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
		return ResponseEntityFactory.find(estadoService.findById(id), EstadoDTO::new);
	}

	@Override
	public ResponseEntity<List<EstadoDTO>> findAll() {
		return ResponseEntityFactory.list(estadoService.findAll(), EstadoDTO::new);
	}

	@Override
	@PermissaoAdmin
	public ResponseEntity<EstadoDTO> insert(@Valid EstadoDTO dto) throws ServiceException {
		Estado estado = estadoService.insert(new Estado(dto));
		return ResponseEntityFactory.created(estado);
	}

	@Override
	@PermissaoAdmin
	public ResponseEntity<Void> update(@Valid EstadoDTO dto, Long id) throws ServiceException {
		dto.setId(id);
		estadoService.update(new Estado(dto));
		return ResponseEntityFactory.noContent();
	}

}
