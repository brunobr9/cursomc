package com.brunobr9.cursomc.services;

import java.time.LocalDateTime;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.domain.enums.EstadoPagamento;
import com.brunobr9.cursomc.exceptions.AuthorizationException;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.repository.RepositoryInterface;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.PedidoRepository;
import com.brunobr9.cursomc.security.UserSS;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class PedidoService implements ServiceInterface<Pedido, Long> {

    private PedidoRepository pedidoRepository;

    private PagamentoService pagamentoService;

    private ClienteService clienteService;

    @Override
    public Pedido processBeforeInsert(Pedido pedido) throws ServiceException {
	pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
	pedido.setDataPedido(LocalDateTime.now());

	pagamentoService.processarPagamento(pedido.getPagamento());

	return pedido;
    }

    @Override
    public RepositoryInterface<Pedido, Long> getRepositoryInterface() {
	return pedidoRepository;
    }

    public Page<Pedido> findPageCliente(Integer page, Integer linesPerPage, String orderBy, String direction)
	    throws ObjectNotFoundException, ServiceException {
	UserSS user = UserService.authenticated();

	if (user == null) {
	    throw new AuthorizationException("Acesso negado");
	}

	return pedidoRepository.findByCliente(clienteService.findById(user.getId()),
		PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
    }

}
