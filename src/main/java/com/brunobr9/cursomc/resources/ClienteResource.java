package com.brunobr9.cursomc.resources;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ApiCrudResources;
import com.brunobr9.cursomc.modelo.resources.ResponseEntityFactory;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource implements ApiCrudResources<ClienteDTO> {

	@Autowired
	private ClienteService clienteService;

	@Override
	public ResponseEntity<ClienteDTO> insert(@Valid ClienteDTO dto) throws ServiceException {
		Cliente cliente = clienteService.insert(new Cliente(dto));
		return ResponseEntityFactory.created(cliente);
	}

	@Override
	public ResponseEntity<Void> update(@Valid ClienteDTO dto, Long id) throws ServiceException {
		dto.setId(id);
		clienteService.update(new Cliente(dto));
		return ResponseEntityFactory.noContent();
	}

	@Override
	public ResponseEntity<ClienteDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
		return ResponseEntityFactory.find(clienteService.findById(id), ClienteDTO::new);
	}

	@Override
	@PermissaoAdmin
	public ResponseEntity<List<ClienteDTO>> findAll() {
		return ResponseEntityFactory.list(clienteService.findAll(), ClienteDTO::new);
	}

}
