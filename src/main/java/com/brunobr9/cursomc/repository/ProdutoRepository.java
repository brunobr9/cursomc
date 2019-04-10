package com.brunobr9.cursomc.repository;

import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Produto;
import com.brunobr9.cursomc.modelo.repository.IdLongNomeRepository;

@Repository
public interface ProdutoRepository extends IdLongNomeRepository<Produto> {

}
