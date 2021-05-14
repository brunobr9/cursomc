package com.brunobr9.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.brunobr9.cursomc.dto.EstadoDTO;
import com.brunobr9.cursomc.modelo.domain.IdLongNomeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estado implements IdLongNomeEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Estado(EstadoDTO dto) {
	id = dto.getId();
	nome = dto.getNome();
    }

}
