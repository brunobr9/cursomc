package com.brunobr9.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.modelo.resources.IdLongResources;
import com.brunobr9.cursomc.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource extends IdLongResources<Categoria> {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {
	return categoriaService.findAll();
    }

}
