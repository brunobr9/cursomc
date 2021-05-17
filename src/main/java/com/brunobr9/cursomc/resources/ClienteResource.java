package com.brunobr9.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ApiResources;
import com.brunobr9.cursomc.modelo.resources.ResponseFactory;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource implements ApiResources<ClienteDTO> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteDTO> insert(@Valid ClienteDTO dto) throws ServiceException {
	Cliente cliente = clienteService.insert(new Cliente(dto));
	return new ResponseFactory<ClienteDTO>().create(cliente.getId());
    }

    @Override
    public ResponseEntity<Void> update(@Valid ClienteDTO dto, Long id) {
	return null;
    }

    @Override
    public ResponseEntity<ClienteDTO> find(Long id) {
	return null;
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<List<ClienteDTO>> findAll() {
	List<ClienteDTO> lista = clienteService.findAll().stream().map(x -> new ClienteDTO(x))
		.collect(Collectors.toList());

	return ResponseEntity.ok().body(lista);
    }

//    @Override
//    public Cliente entityConverter(ClienteDTO dto) {
//	return new Cliente(dto);
//    }
//
//    @Override
//    public ClienteDTO dataObjectConverter(Cliente entity) {
//	return new ClienteDTO(entity);
//    }
//
//    @Override
//    public ResponseEntity<ClienteDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
//	return ResourcesInterface.super.find(id);
//    }

}
