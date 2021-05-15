package com.brunobr9.cursomc.domain;

import java.time.LocalDateTime;

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
    private LocalDateTime dataVencimento;

    @Column(nullable = true)
    private LocalDateTime dataPagamento;

    @Override
    public void processarPagamento() {
	super.processarPagamento();
	setDataPagamento(getDataCadastro());
	setDataVencimento(dataPagamento.plusDays(3));
    }

}
