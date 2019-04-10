package com.brunobr9.cursomc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = false)
    private Date dataPagamento;

}
