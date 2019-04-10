package com.brunobr9.cursomc.modelo.resources;

import com.brunobr9.cursomc.modelo.domain.IdEntity;

public abstract class AbstractCrudResources<T extends IdEntity<ID>, ID> implements CrudResources<T, ID> {
    
}
