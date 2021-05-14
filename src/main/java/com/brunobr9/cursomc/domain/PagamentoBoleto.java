package com.brunobr9.cursomc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PagamentoBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = true)
    private Date dataPagamento;

}
