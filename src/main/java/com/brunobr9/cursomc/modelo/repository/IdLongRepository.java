package com.brunobr9.cursomc.modelo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.brunobr9.cursomc.modelo.domain.IdEntity;

@NoRepositoryBean
public interface IdLongRepository<T extends IdEntity<Long>> extends RepositoryInterface<T, Long> {
    
}
