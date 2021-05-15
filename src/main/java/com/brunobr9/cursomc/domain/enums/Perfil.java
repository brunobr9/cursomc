package com.brunobr9.cursomc.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Perfil {

    CLIENTE("Cliente"), 
    ADMIN("Administrador");

    private String label;

}
