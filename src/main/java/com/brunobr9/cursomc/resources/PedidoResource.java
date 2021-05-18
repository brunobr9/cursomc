package com.brunobr9.cursomc.resources;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.dto.PedidoDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ResourcesInterface;
import com.brunobr9.cursomc.services.PedidoService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoResource implements ResourcesInterface<PedidoDTO, Pedido> {

    @Getter
    private PedidoService service;

    @Override
    public Pedido entityConverter(PedidoDTO dto) {
	return new Pedido(dto);
    }

    @Override
    public PedidoDTO dataObjectConverter(Pedido pedido) {
	return new PedidoDTO(pedido);
    }

    @GetMapping(path = PAGE + "-cliente")
    public ResponseEntity<Page<PedidoDTO>> findPageCliente(
	    @RequestParam(value = "page", defaultValue = "0") Integer page,
	    @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
	    @RequestParam(value = "orderBy", defaultValue = "dataPedido") String orderBy,
	    @RequestParam(value = "direction", defaultValue = "DESC") String direction)
	    throws ObjectNotFoundException, ServiceException {

	Page<Pedido> pageEntity = getService().findPageCliente(page, linesPerPage, orderBy, direction);
	Page<PedidoDTO> pageDTO = pageEntity.map(this::dataObjectConverter);

	return ResponseEntity.ok().body(pageDTO);
    }

}
