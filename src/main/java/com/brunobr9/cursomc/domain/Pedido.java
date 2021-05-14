package com.brunobr9.cursomc.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.brunobr9.cursomc.modelo.domain.IdEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Pedido implements IdEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido", fetch = FetchType.LAZY)
    private Set<ItemPedido> itensPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enderecoEntrega_id", nullable = false)
    private Endereco enderecoEntrega;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pagamento_id", nullable = false)
    private Pagamento pagamento;

    public Pedido() {
	itensPedido = new HashSet<>();
    }
}
