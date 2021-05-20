package com.brunobr9.cursomc.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Pagamento;
import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.modelo.services.AbstractCrudService;

@Service
public class PagamentoService extends AbstractCrudService<Pagamento, Long> {

    public void processarPagamento(Pagamento pagamento) throws ServiceException {
	pagamento.processarPagamento();
	super.insert(pagamento);
    }

}
