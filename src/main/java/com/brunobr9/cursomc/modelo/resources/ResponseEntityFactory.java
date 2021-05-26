package com.brunobr9.cursomc.modelo.resources;

import java.net.URI;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunobr9.cursomc.modelo.domain.IdEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseEntityFactory {

	/**
	 * 
	 * @param <S> dto
	 * @param id
	 * @return ResponseEntity after insert
	 */
	public static <S, T extends IdEntity<ID>, ID> ResponseEntity<S> created(T t) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ApiCrudResources.PATH_ID)
				.buildAndExpand(t.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	/**
	 * 
	 * @return void content
	 */
	public static ResponseEntity<Void> noContent() {
		return ResponseEntity.noContent().build();
	}

	/**
	 * 
	 * @param <S>       dto
	 * @param <T>       entity
	 * @param list
	 * @param converter
	 * @return ResponseEntity of list
	 */
	public static <S, T> ResponseEntity<List<S>> list(List<T> list, Function<T, S> converter) {
		return ResponseEntity.ok().body(list.stream().map(converter).collect(Collectors.toList()));
	}

	/**
	 * 
	 * @param <S>       dto
	 * @param <T>       entity
	 * @param t         entity
	 * @param converter
	 * @return ResponseEntity of find
	 */
	public static <S, T> ResponseEntity<S> find(T t, Function<T, S> converter) {
		return ResponseEntity.ok().body(converter.apply(t));
	}

	/**
	 * 
	 * @param <S>       dto
	 * @param <T>       entity
	 * @param page      page entity
	 * @param converter
	 * @return ResponseEntity of page
	 */
	public static <S, T> ResponseEntity<Page<S>> page(Page<T> page, Function<T, S> converter) {
		return ResponseEntity.ok().body(page.map(converter));
	}

}
