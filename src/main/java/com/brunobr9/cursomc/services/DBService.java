package com.brunobr9.cursomc.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.domain.Cidade;
import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.domain.Endereco;
import com.brunobr9.cursomc.domain.Estado;
import com.brunobr9.cursomc.domain.ItemPedido;
import com.brunobr9.cursomc.domain.PagamentoBoleto;
import com.brunobr9.cursomc.domain.Pedido;
import com.brunobr9.cursomc.domain.Produto;
import com.brunobr9.cursomc.domain.enums.Perfil;
import com.brunobr9.cursomc.domain.enums.TipoCliente;
import com.brunobr9.cursomc.exceptions.ServiceException;

@Service
public class DBService {

    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private EstadoService estadoService;
    
    @Autowired
    private CidadeService cidadeService;
    
    @Autowired
    private EnderecoService enderecoService;
    
    @Autowired
    private PedidoService pedidoService;

    public void initDatabase() throws ServiceException {
	Estado estado = Estado.builder().nome("Rio Grande do Norte").sigla("RN").build();
	estado = estadoService.insert(estado);
	
	Cidade cidade = Cidade.builder().nome("Natal").estado(estado).build();
	cidade = cidadeService.insert(cidade);
	
	Endereco end = Endereco.builder()
		.logradouro("Rua das Aves")
		.numero("9090")
		.bairro("Pitimbu")
		.cep("541269")
		.cidade(cidade)
		.build();
	end = enderecoService.insert(end);
	
	Categoria c1 = new Categoria(null, "Tecnologia");
	Categoria c2 = new Categoria(null, "Móveis");
	Categoria c3 = new Categoria(null, "Cama, Mesa e Banho");
	Categoria c4 = new Categoria(null, "Vestuário");
	categoriaService.insertAll(Arrays.asList(c1, c2, c3, c4));
	
	Categoria catTec = categoriaService.findByNome("Tecnologia");
	Produto produto1 = Produto.builder().categoria(catTec).preco(new BigDecimal(200)).nome("Teclado").build();
	Produto produto2 = Produto.builder().categoria(catTec).preco(new BigDecimal(100)).nome("Mouse").build();
	produtoService.insertAll(Arrays.asList(produto1, produto2));	
	
	Cliente cl1 = Cliente.builder()
		.nome("Bruno")
		.email("bruno@hotmail.com")
		.cpfOuCnpj("09545512205")
		.endereco(end)
		.tipoCliente(TipoCliente.PESSOA_FISICA)
		.telefone(null)
		.senha("123456")
		.build();
	cl1.addPerfil(Perfil.ADMIN);
	cl1 = clienteService.insert(cl1);
	
	Cliente cl2 = Cliente.builder()
		.nome("Ana")
		.email("ana@hotmail.com")
		.cpfOuCnpj("04587513408")
		.endereco(end)
		.tipoCliente(TipoCliente.PESSOA_FISICA)
		.telefone(null)
		.senha("987654")
		.perfis(new HashSet<>(Arrays.asList(Perfil.CLIENTE)))
		.build();
	 cl2 = clienteService.insert(cl2);
	
	Pedido pedido = Pedido.builder()
		.dataPedido(LocalDateTime.now())
		.cliente(cl1)
		.enderecoEntrega(cl1.getEndereco())
		.pagamento(new PagamentoBoleto())
		.itensPedido(null)
		.build();
	ItemPedido item1 = ItemPedido.builder()
		.pedido(pedido)
		.produto(produto1)
		.desconto(BigDecimal.ZERO)
		.quantidade(1)
		.build();
	ItemPedido item2 = ItemPedido.builder()
		.pedido(pedido)
		.produto(produto2)
		.desconto(BigDecimal.ZERO)
		.quantidade(1)
		.build();
	pedido.setItensPedido(new HashSet<>(Arrays.asList(item1, item2)));	
	pedidoService.insert(pedido);
    }
}
