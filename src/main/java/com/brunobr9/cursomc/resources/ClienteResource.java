package com.brunobr9.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.dto.CategoriaDTO;
import com.brunobr9.cursomc.modelo.resources.ResourcesInterface;
import com.brunobr9.cursomc.services.CategoriaService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class ClienteResource implements ResourcesInterface<CategoriaDTO, Categoria> {

    @Getter
    private CategoriaService service;

    @Override
    public Categoria entityConverter(CategoriaDTO categoriaDTO) {
	return new Categoria(categoriaDTO);
    }

    @Override
    public CategoriaDTO dataObjectConverter(Categoria categoria) {
	return new CategoriaDTO(categoria);
    }

}
