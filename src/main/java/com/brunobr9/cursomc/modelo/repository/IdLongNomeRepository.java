package com.brunobr9.cursomc.modelo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.brunobr9.cursomc.modelo.domain.IdLongNomeEntity;

@NoRepositoryBean
public interface IdLongNomeRepository<T extends IdLongNomeEntity> extends IdLongRepository<T> {

    T findByNome(String nome);
}	