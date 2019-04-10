package com.brunobr9.cursomc.modelo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.brunobr9.cursomc.modelo.domain.IdLongNomeMapped;

@NoRepositoryBean
public interface IdLongNomeRepository<T extends IdLongNomeMapped> extends IdLongRepository<T> {

    T findByNome(String nome);
}