package com.brunobr9.cursomc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO implements IdEntityDTO<String> {

    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;

    @Override
    public String getId() {
	return email;
    }

    @Override
    public void setId(String usuario) {
	this.email = usuario;
    }
}
