package com.brunobr9.cursomc.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.brunobr9.cursomc.modelo.domain.IdLongNomeMapped;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto extends IdLongNomeMapped {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private BigDecimal preco;

}
