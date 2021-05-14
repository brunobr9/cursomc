package com.brunobr9.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "numeroParcelas")
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer numeroParcelas;

    @Column(nullable = false)
    private String numeroCartao;

}
