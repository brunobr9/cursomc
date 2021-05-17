package com.brunobr9.cursomc.dto;

import java.time.LocalDateTime;

import com.brunobr9.cursomc.domain.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements IdEntityDTO<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime dataPedido;
    private ClienteDTO cliente;

    public PedidoDTO(Pedido pedido) {
	id = pedido.getId();
	dataPedido = pedido.getDataPedido();
	cliente = new ClienteDTO(pedido.getCliente());
    }

}
