package com.brunobr9.cursomc.dto;

import java.io.Serializable;

public interface IdEntityDTO<T> extends Serializable {

    T getId();

    void setId(T t);

}
