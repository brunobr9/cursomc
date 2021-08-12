package com.brunobr9.cursomc.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.exceptions.AuthorizationException;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.services.AbstractCrudService;
import com.brunobr9.cursomc.repository.PedidoRepository;
import com.brunobr9.cursomc.security.UserSS;

@Service
public class PedidoService extends AbstractCrudService<Pedido, Long> {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private ClienteService clienteService;

	@Override
	protected Pedido processBeforeInsert(Pedido pedido) throws ServiceException {
		pedido.realizarPedido();
		pagamentoService.processarPagamento(pedido.getPagamento());

		return pedido;
	}

	public Page<Pedido> findPageByCliente(Integer page, Integer linesPerPage, String orderBy, String direction)
			throws ObjectNotFoundException, ServiceException {
		UserSS user = UserService.authenticated();

		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		return pedidoRepository.findByCliente(clienteService.findById(user.getId()),
				PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
	}

}
