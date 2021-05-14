package com.brunobr9.cursomc.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.brunobr9.cursomc.domain.Categoria;

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
public class CategoriaDTO implements IdEntityDTO<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 15, message = "O nome deve ter entre 5 e 15 caracteres")
    private String nome;

    public CategoriaDTO(Categoria categoria) {
	id = categoria.getId();
	nome = categoria.getNome();
    }
}
