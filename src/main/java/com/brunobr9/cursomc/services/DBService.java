package com.brunobr9.cursomc.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.domain.Categoria;
import com.brunobr9.cursomc.exceptions.ServiceException;

@Service
public class DBService {

    @Autowired
    private CategoriaService categoriaService;

    public void deleteAll() {
	categoriaService.getRepositoryInterface().deleteAll();
    }

    public void initDatabase() throws ServiceException {
	Categoria c1 = new Categoria(null, "Tecnologia");
	Categoria c2 = new Categoria(null, "Móveis");
	Categoria c3 = new Categoria(null, "Cama, Mesa e Banho");
	Categoria c4 = new Categoria(null, "Vestuário");

	categoriaService.insertAll(Arrays.asList(c1, c2, c3, c4));
    }
}
