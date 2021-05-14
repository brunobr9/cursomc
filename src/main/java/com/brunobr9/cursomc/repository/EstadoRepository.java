package com.brunobr9.cursomc.repository;

import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Estado;
import com.brunobr9.cursomc.modelo.repository.IdLongNomeRepository;

@Repository
public interface EstadoRepository extends IdLongNomeRepository<Estado> {

}
