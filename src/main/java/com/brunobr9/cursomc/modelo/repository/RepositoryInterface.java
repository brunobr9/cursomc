package com.brunobr9.cursomc.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.brunobr9.cursomc.modelo.domain.IdEntity;

@NoRepositoryBean
public interface RepositoryInterface<T extends IdEntity<ID>, ID> extends JpaRepository<T, ID> {

}
