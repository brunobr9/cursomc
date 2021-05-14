package com.brunobr9.cursomc.dto.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.constraints.NotEmpty;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty(message = "Preenchimento Obrigatório")
public @interface CampoObrigatorio {


}
	