package com.brunobr9.cursomc.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.modelo.domain.IdLongNomeMapped;
import com.brunobr9.cursomc.modelo.repository.IdLongNomeRepository;

@Service
public abstract class IdLongNomeService<T extends IdLongNomeMapped> extends IdLongService<T> {

    @Autowired
    protected IdLongNomeRepository<T> idLongNomeRepository;

    public T findByNome(String nome) {
	return idLongNomeRepository.findByNome(nome);
    }

}
