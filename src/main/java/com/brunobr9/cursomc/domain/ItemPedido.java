package com.brunobr9.cursomc.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.brunobr9.cursomc.modelo.domain.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
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
	public ItemPedido(Pedido pedido, Produto produto, BigDecimal desconto, Integer quantidade) {
		this.id = ItemPedidoPK.builder().pedido(pedido).produto(produto).build();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = produto.getPreco();
	}

	public BigDecimal getSubTotal() {
		BigDecimal precoComDesconto = preco.subtract(desconto);
		return precoComDesconto.multiply(new BigDecimal(String.valueOf(quantidade)));
	}

	public String getPrecoString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return nf.format(getPreco());
	}

}
