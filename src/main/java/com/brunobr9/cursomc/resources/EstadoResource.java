package com.brunobr9.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Estado;
import com.brunobr9.cursomc.dto.EstadoDTO;
import com.brunobr9.cursomc.modelo.resources.ResourcesInterface;
import com.brunobr9.cursomc.services.EstadoService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/estado")
@AllArgsConstructor
public class EstadoResource implements ResourcesInterface<EstadoDTO, Estado> {

    @Getter
    private EstadoService service;

    @Override
    public Estado entityConverter(EstadoDTO dto) {
	return new Estado(dto);
    }

    @Override
    public EstadoDTO dataObjectConverter(Estado entity) {
	return new EstadoDTO(entity);
    }

}
