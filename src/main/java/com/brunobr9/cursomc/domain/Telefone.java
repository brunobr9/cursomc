package com.brunobr9.cursomc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.brunobr9.cursomc.modelo.domain.IdLongMapped;

@Entity
public class Telefone extends IdLongMapped {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    String numero;

}
