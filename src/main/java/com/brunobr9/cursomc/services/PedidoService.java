package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.domain.enums.EstadoPagamento;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.PedidoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class PedidoService implements ServiceInterface<Pedido, Long> {

    private PedidoRepository repositoryInterface;
    
    @Override
    public void processBeforeInsert() {
	
    }
    
    private void processarPedido(Pedido pedido) {
    }

}
