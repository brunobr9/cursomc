package com.brunobr9.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.dto.CategoriaDTO;
import com.brunobr9.cursomc.modelo.resources.ApiResources;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.CategoriaService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaResource implements ApiResources<CategoriaDTO> {

    @Getter
    private CategoriaService service;

    @Override
    @PermissaoAdmin
    public ResponseEntity<CategoriaDTO> insert(@Valid CategoriaDTO dto) {
	return null;
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<Void> update(@Valid CategoriaDTO dto, Long id) {
	return null;
    }

    @Override
    public ResponseEntity<CategoriaDTO> find(Long id) {
	return null;
    }

    @Override
    public ResponseEntity<List<CategoriaDTO>> findAll() {
	List<CategoriaDTO> lista = getService().findAll().stream().map(x -> new CategoriaDTO(x))
		.collect(Collectors.toList());

	return ResponseEntity.ok().body(lista);
    }

//    @Override
//    public Categoria entityConverter(CategoriaDTO categoriaDTO) {
//	return new Categoria(categoriaDTO);
//    }
//
//    @Override
//    public CategoriaDTO dataObjectConverter(Categoria categoria) {
//	return new CategoriaDTO(categoria);
//    }

}
