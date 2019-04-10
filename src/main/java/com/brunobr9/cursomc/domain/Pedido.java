package com.brunobr9.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.brunobr9.cursomc.domain.enums.EstadoPagamento;
import com.brunobr9.cursomc.modelo.domain.IdLongMapped;

public class Pedido extends IdLongMapped {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPagamento estadoPagamento;

}
