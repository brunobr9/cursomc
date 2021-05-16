package com.brunobr9.cursomc.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EstadoPagamento {

    PENDENTE("Pendente"), 
    CONFIRMADO("Confirmado"), 
    CANCELADO("Cancelado");

    @Getter
    private String label;

}
