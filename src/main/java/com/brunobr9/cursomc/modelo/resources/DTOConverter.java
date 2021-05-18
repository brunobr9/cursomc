package com.brunobr9.cursomc.modelo.resources;

/**
 * 
 * @author Bruno
 *
 * @param <S> dto
 * @param <T> entity
 */
@FunctionalInterface
public interface DTOConverter<S, T> {

	S toDTO(T t);
}
