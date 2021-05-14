package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.CategoriaRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class CategoriaService implements ServiceInterface<Categoria, Long> {

    private CategoriaRepository repositoryInterface;

    public Categoria findByNome(String nome) {
	return repositoryInterface.findByNome(nome);
    }

}
