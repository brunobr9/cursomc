package com.brunobr9.cursomc.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.domain.enums.Perfil;
import com.brunobr9.cursomc.exceptions.AuthorizationException;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.ClienteRepository;
import com.brunobr9.cursomc.security.UserSS;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class ClienteService implements ServiceInterface<Cliente, Long> {

    private ClienteRepository repositoryInterface;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Cliente processBeforeInsert(Cliente cliente) throws ServiceException {
	cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
	return cliente;
    }

    @Override
    public Cliente processBeforeUpdate(Cliente cliente) throws ServiceException {
	Cliente clienteDB = repositoryInterface.findById(cliente.getId()).orElse(null);
	if (clienteDB == null) {
	    throw new ServiceException("Cliente não encontrado.");
	}
	clienteDB.setNome(cliente.getNome());
	clienteDB.setEmail(cliente.getEmail());

	return clienteDB;
    }

    public Cliente findByEmail(String email) {
	return repositoryInterface.findByEmail(email);
    }

    @Override
    public Cliente findById(Long id) throws ObjectNotFoundException, ServiceException {
	UserSS user = UserService.authenticated();
	if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
	    throw new AuthorizationException("Acesso negado.");
	}

	return ServiceInterface.super.findById(id);
    }

}
