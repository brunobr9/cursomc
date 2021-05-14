package com.brunobr9.cursomc.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.brunobr9.cursomc.modelo.domain.IdLongNomeEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto implements IdLongNomeEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "id.produto", fetch = FetchType.LAZY)
    private Set<ItemPedido> itensPedido;

    public List<Pedido> getPedidos() {
	return itensPedido.stream().map(ItemPedido::getPedido).collect(Collectors.toList());
    }

    public Produto() {
	itensPedido = new HashSet<>();
    }

    public BigDecimal getValorTotal() {
	return itensPedido.stream().map(ItemPedido::getSubTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

}
