package com.brunobr9.cursomc.dto;

import java.math.BigDecimal;

import com.brunobr9.cursomc.domain.Produto;

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
public class ProdutoDTO implements IdEntityDTO<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private BigDecimal valorTotal;

    public ProdutoDTO(Produto produto) {
	id = produto.getId();
	nome = produto.getNome();
	valorTotal = produto.getValorTotal();
    }

}
