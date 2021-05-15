package com.brunobr9.cursomc.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.services.ClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private ClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Cliente cliente = clienteService.findByEmail(username);

	if (cliente == null) {
	    throw new UsernameNotFoundException("Cliente não encontrado."
	    	+ "");
	}

	return new UserSS(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
    }

}
