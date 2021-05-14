package com.brunobr9.cursomc.repository;

import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.modelo.repository.IdLongNomeRepository;

@Repository
public interface CategoriaRepository extends IdLongNomeRepository<Categoria> {
    
}
