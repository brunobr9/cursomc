package com.brunobr9.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.dto.CategoriaDTO;
import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.modelo.resources.ResourcesInterface;
import com.brunobr9.cursomc.services.CategoriaService;
import com.brunobr9.cursomc.services.ClienteService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class CategoriaResource implements ResourcesInterface<ClienteDTO, Cliente> {

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

}
