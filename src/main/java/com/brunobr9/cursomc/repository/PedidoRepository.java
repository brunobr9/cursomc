package com.brunobr9.cursomc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.modelo.repository.IdLongRepository;

@Repository
public interface PedidoRepository extends IdLongRepository<Pedido> {
    
    Page<Pedido> findByCliente(Cliente cliente, Pageable pageable);
    
}
