package com.brunobr9.cursomc.repository;

import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.modelo.repository.IdLongNomeRepository;

@Repository
public interface ClienteRepository extends IdLongNomeRepository<Cliente> {

    Cliente findByEmail(String email);
}
