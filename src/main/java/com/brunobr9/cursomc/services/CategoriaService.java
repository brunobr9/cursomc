package com.brunobr9.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.modelo.services.AbstractCrudService;
import com.brunobr9.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService extends AbstractCrudService<Categoria, Long> {

	@Autowired
	private CategoriaRepository repositoryInterface;

	public Categoria findByNome(String nome) {
		return repositoryInterface.findByNome(nome);
	}

}
