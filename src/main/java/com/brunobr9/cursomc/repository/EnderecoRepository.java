package com.brunobr9.cursomc.repository;

import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Endereco;
import com.brunobr9.cursomc.modelo.repository.IdLongRepository;

@Repository
public interface EnderecoRepository extends IdLongRepository<Endereco> {
    
}
