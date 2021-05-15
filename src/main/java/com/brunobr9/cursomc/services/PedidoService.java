package com.brunobr9.cursomc.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.domain.enums.EstadoPagamento;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.PedidoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class PedidoService implements ServiceInterface<Pedido, Long> {

    private PedidoRepository pedidoRepository;
    
    private PagamentoService pagamentoService;

    @Override
    public void processBeforeInsert(Pedido pedido) throws ServiceException {
	pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
	pedido.setDataPedido(LocalDateTime.now());
	
	pagamentoService.processarPagamento(pedido.getPagamento());
	 
	//TODO processar ItemPedido
    }

    @Override
    public RepositoryInterface<Pedido, Long> getRepositoryInterface() {
	return pedidoRepository;
    }

}
