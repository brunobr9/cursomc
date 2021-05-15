package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Produto;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.ProdutoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class ProdutoService implements ServiceInterface<Produto, Long> {

    private ProdutoRepository repositoryInterface;

}
