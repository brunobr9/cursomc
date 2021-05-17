package com.brunobr9.cursomc.resources;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.modelo.resources.ResourcesInterface;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.ClienteService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteResource implements ResourcesInterface<ClienteDTO, Cliente> {

    @Getter
    private ClienteService service;

    @Override
    public Cliente entityConverter(ClienteDTO dto) {
	return new Cliente(dto);
    }

    @Override
    public ClienteDTO dataObjectConverter(Cliente entity) {
	return new ClienteDTO(entity);
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<List<ClienteDTO>> findAll() {
	return ResourcesInterface.super.findAll();
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<Page<ClienteDTO>> findPage(Integer page, Integer linesPerPage, String orderBy,
	    String direction) {
	return ResourcesInterface.super.findPage(page, linesPerPage, orderBy, direction);
    }
}
