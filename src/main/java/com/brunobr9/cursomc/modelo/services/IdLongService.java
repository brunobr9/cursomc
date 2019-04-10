package com.brunobr9.cursomc.modelo.services;

import org.springframework.stereotype.Service;

import com.brunobr9.cursomc.modelo.domain.IdLongMapped;

@Service
public abstract class IdLongService<T extends IdLongMapped> extends AbstractService<T, Long> {

}
