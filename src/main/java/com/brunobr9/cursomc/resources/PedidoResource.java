package com.brunobr9.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.dto.PedidoDTO;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.resources.ApiCrudResources;
import com.brunobr9.cursomc.modelo.resources.ResponseFactory;
import com.brunobr9.cursomc.modelo.resources.annotations.PermissaoAdmin;
import com.brunobr9.cursomc.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource implements ApiCrudResources<PedidoDTO> {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(path = PAGE)
    public ResponseEntity<Page<PedidoDTO>> findPageCliente(
	    @RequestParam(value = "page", defaultValue = "0") Integer page,
	    @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
	    @RequestParam(value = "orderBy", defaultValue = "dataPedido") String orderBy,
	    @RequestParam(value = "direction", defaultValue = "DESC") String direction)
	    throws ObjectNotFoundException, ServiceException {

	Page<Pedido> pageEntity = pedidoService.findPageByCliente(page, linesPerPage, orderBy, direction);
	Page<PedidoDTO> pageDTO = pageEntity.map(x -> new PedidoDTO(x));

	return ResponseEntity.ok().body(pageDTO);
    }

    @Override
    public ResponseEntity<PedidoDTO> insert(@Valid PedidoDTO dto) throws ServiceException {
	return new ResponseFactory<PedidoDTO>().create(pedidoService.insert(new Pedido(dto)).getId());
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<Void> update(@Valid PedidoDTO dto, Long id) throws ServiceException {
	dto.setId(id);
	pedidoService.update(new Pedido(dto));
	return ResponseFactory.create();
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<PedidoDTO> find(Long id) throws ObjectNotFoundException, ServiceException {
	return ResponseEntity.ok().body(new PedidoDTO(pedidoService.findById(id)));
    }

    @Override
    @PermissaoAdmin
    public ResponseEntity<List<PedidoDTO>> findAll() {
	return ResponseEntity.ok()
		.body(pedidoService.findAll().stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList()));
    }

}