package com.brunobr9.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.brunobr9.cursomc.domain.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements IdEntityDTO<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 8, message = "O nome deve ter entre 5 e 8 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Email inválido")
	private String email;

	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
	}
}
