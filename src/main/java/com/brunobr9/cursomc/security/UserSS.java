package com.brunobr9.cursomc.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.brunobr9.cursomc.domain.enums.Perfil;

import lombok.Getter;

public class UserSS implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Getter
    private Long id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS(Long id, String email, String senha, Set<Perfil> perfis) {
	super();
	this.id = id;
	this.email = email;
	this.senha = senha;
	authorities = perfis.stream().map(p -> new SimpleGrantedAuthority("ROLE_" + p.getLabel()))
		.collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
    }

    @Override
    public String getPassword() {
	return senha;
    }

    @Override
    public String getUsername() {
	return email;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    public boolean hasRole(Perfil perfil) {
	return authorities.stream().map(x -> x.getAuthority()).anyMatch(x -> x.equals("ROLE_" + perfil.getLabel()));
    }

}
