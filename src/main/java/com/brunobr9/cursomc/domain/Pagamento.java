package com.brunobr9.cursomc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.brunobr9.cursomc.modelo.domain.IdLongMapped;

import lombok.EqualsAndHashCode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true, exclude = "dataCadastro")
public abstract class Pagamento extends IdLongMapped {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Date dataCadastro;
}
