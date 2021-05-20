package com.brunobr9.cursomc.modelo.services;

/**
 * 
 * @author bruno
 *
 * @param <S> dto
 * @param <T> entity
 */
@FunctionalInterface
public interface EntityConverter<S, T> {

	T toEntity(S s);
}
