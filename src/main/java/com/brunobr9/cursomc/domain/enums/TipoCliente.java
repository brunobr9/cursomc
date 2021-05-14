package com.brunobr9.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCliente {

    PESSOA_FISICA("Pessoa Física"), 
    PESSOA_JURIDICA("Pessoa Jurídica");

    private String label;

//    public static TipoCliente toEnum(Integer codigo) {
//	if (codigo == null) {
//	    return null;
//	}
//
//	for (TipoCliente t : TipoCliente.values()) {
//	    if (codigo.equals(t.getCodigo())) {
//		return t;
//	    }
//	}
//
//	throw new IllegalArgumentException("codigo invalido");
//    }

}
