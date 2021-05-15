package com.brunobr9.cursomc.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.ClienteRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class ClienteService implements ServiceInterface<Cliente, Long> {

    private ClienteRepository repositoryInterface;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void processBeforeInsert(Cliente object) throws ServiceException {
	object.setSenha(bCryptPasswordEncoder.encode(object.getSenha()));
	ServiceInterface.super.processBeforeInsert(object);
    }

}
