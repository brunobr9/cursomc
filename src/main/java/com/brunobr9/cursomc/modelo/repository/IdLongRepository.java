package com.brunobr9.cursomc.modelo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.brunobr9.cursomc.modelo.domain.IdLongMapped;

@NoRepositoryBean
public interface IdLongRepository<T extends IdLongMapped> extends RepositoryInterface<T, Long> {

}
