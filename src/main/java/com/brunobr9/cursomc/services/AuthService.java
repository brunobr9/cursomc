package com.brunobr9.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Cliente;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void sendNewPassword(String email) throws ObjectNotFoundException {
		Cliente cliente = clienteService.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado.");
		}

		String newPass = newPassword();
		cliente.setSenha(passwordEncoder.encode(newPass));
		//TODO update cliente
		//TODO email.sendNewPass
	}

	private String newPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
