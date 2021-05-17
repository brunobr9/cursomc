package com.brunobr9.cursomc.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.modelo.resources.ApiResources;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.ClienteService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteResource implements ApiResources<ClienteDTO> {

    @Getter
    private ClienteService service;

    @Override
    public ResponseEntity<ClienteDTO> insert(@Valid ClienteDTO dto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseEntity<Void> update(@Valid ClienteDTO dto, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseEntity<ClienteDTO> find(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<List<ClienteDTO>> findAll() {
	// TODO Auto-generated method stub
	return null;
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
