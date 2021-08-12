package com.brunobr9.cursomc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.brunobr9.cursomc.domain.enums.Perfil;
import com.brunobr9.cursomc.domain.enums.TipoCliente;
import com.brunobr9.cursomc.dto.ClienteDTO;
import com.brunobr9.cursomc.modelo.domain.IdLongNomeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements IdLongNomeEntity {

	private static final long serialVersionUID = 1L;

//    private static final Set<Perfil> perfilDefault = new HashSet<>(Arrays.asList(Perfil.CLIENTE));

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false, unique = true)
	private String cpfOuCnpj;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;

	@Column(nullable = true)
	private String telefone;

	@Builder.Default
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	@Enumerated(EnumType.STRING)
	private Set<Perfil> perfis = new HashSet<>();

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil);
	}

	public Cliente(ClienteDTO dto) {
		id = dto.getId();
		nome = dto.getNome();
		email = dto.getEmail();
	}

	public void atualizarCliente(Cliente cliente) {
		setNome(cliente.getNome());
		setEmail(cliente.getEmail());
	}
}
