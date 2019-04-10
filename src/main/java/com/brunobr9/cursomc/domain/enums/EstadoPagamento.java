package com.brunobr9.cursomc.domain.enums;

import lombok.Getter;

public enum EstadoPagamento {

    PENDENTE("Pendente"), 
    CONFIRMADO("Confirmado"), 
    CANCELADO("Cancelado");

    @Getter
    private String label;

    private EstadoPagamento(String label) {
	this.label = label;
    }

}
