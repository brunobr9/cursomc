package com.brunobr9.cursomc.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.domain.Cidade;
import com.brunobr9.cursomc.domain.Cliente;
import com.brunobr9.cursomc.domain.Endereco;
import com.brunobr9.cursomc.domain.Estado;
import com.brunobr9.cursomc.domain.Produto;
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

    public void initDatabase() throws ServiceException {
	Estado estado = Estado.builder().nome("Rio Grande do Norte").sigla("RN").build();
	estado = estadoService.insert(estado);
	
	Cidade cidade = Cidade.builder().nome("Natal").estado(estado).build();
	cidade = cidadeService.insert(cidade);
	
	Endereco end = Endereco.builder()
		.logradouro("Rua das Andorinhas")
		.numero("8074")
		.bairro("Pitimbu")
		.cep("59067390")
		.cidade(cidade)
		.build();
	end = enderecoService.insert(end);
	
	Categoria c1 = new Categoria(null, "Tecnologia");
	Categoria c2 = new Categoria(null, "Móveis");
	Categoria c3 = new Categoria(null, "Cama, Mesa e Banho");
	Categoria c4 = new Categoria(null, "Vestuário");
	categoriaService.insertAll(Arrays.asList(c1, c2, c3, c4));
	
	Categoria catTec = categoriaService.findByNome("Tecnologia");
	Produto p1 = Produto.builder().categoria(catTec).preco(new BigDecimal(200)).nome("Teclado").build();
	Produto p2 = Produto.builder().categoria(catTec).preco(new BigDecimal(100)).nome("Mouse").build();
	produtoService.insertAll(Arrays.asList(p1, p2));	
	
	Cliente cl1 = Cliente.builder()
		.nome("Bruno Henrique Souza dos Santos")
		.email("brunobr9@hotmail.com")
		.cpfOuCnpj("09845813402")
		.endereco(end)
		.tipoCliente(TipoCliente.PESSOA_FISICA)
		.telefone(null)
		.senha("2f9437F8H")
		.build();
	clienteService.insert(cl1);
	
//	Pedido.builder()
//		.dataPedido(LocalDateTime.now())
//		.cliente(null)
//		.enderecoEntrega(null)
//		.pagamento(new PagamentoBoleto());
//	
	
//	ItemPedido.builder().produto(p1)

    }
}
