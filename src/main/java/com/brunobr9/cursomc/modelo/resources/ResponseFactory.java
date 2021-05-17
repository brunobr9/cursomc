package com.brunobr9.cursomc.modelo.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ResponseFactory<T> {

    public ResponseEntity<T> create(Long id) {
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ApiResources.PATH_ID).buildAndExpand(id)
		.toUri();

	return ResponseEntity.created(uri).build();
    }
}
