package com.brunobr9.cursomc.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class ItemPedido implements IdEntity<ItemPedidoPK> {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemPedidoPK id;

    @Column(nullable = true)
    private BigDecimal desconto;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer quantidade;

    @JsonIgnore
    public Pedido getPedido() {
	return id.getPedido();
    }

    public Produto getProduto() {
	return id.getProduto();
    }

    @Builder
    public ItemPedido(Pedido pedido, Produto produto, BigDecimal desconto, BigDecimal preco, Integer quantidade) {
	this.id.setPedido(pedido);
	this.id.setProduto(produto);
	this.desconto = desconto;
	this.preco = preco;
	this.quantidade = quantidade;
    }

    public BigDecimal getSubTotal() {
	return (preco.subtract(desconto)).multiply(new BigDecimal(String.valueOf(quantidade)));
    }

}
