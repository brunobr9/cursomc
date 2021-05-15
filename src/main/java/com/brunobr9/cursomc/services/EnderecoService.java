package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Endereco;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.EnderecoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class EnderecoService implements ServiceInterface<Endereco, Long> {

    private EnderecoRepository repositoryInterface;


}
