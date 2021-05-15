package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pagamento;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.services.ServiceInterface;
import com.brunobr9.cursomc.repository.PagamentoRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class PagamentoService implements ServiceInterface<Pagamento, Long> {

    private PagamentoRepository repositoryInterface;

    public void processarPagamento(Pagamento pagamento) throws ServiceException {
	pagamento.processarPagamento();
	ServiceInterface.super.insert(pagamento);
    }

}
