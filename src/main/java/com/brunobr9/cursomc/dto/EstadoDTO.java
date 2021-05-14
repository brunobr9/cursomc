package com.brunobr9.cursomc.dto;

import com.brunobr9.cursomc.domain.Estado;

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
public class EstadoDTO implements IdEntityDTO<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public EstadoDTO(Estado entity) {
	id = entity.getId();
	nome = entity.getNome();
    }

}
