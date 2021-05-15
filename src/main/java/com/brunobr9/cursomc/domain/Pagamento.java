package com.brunobr9.cursomc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.brunobr9.cursomc.domain.enums.EstadoPagamento;
import com.brunobr9.cursomc.modelo.domain.IdEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false, exclude = "dataCadastro")
public abstract class Pagamento implements IdEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPagamento estadoPagamento;

    public void processarPagamento() {
	setDataCadastro(LocalDateTime.now());
    }

}
