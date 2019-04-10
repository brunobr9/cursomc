package com.brunobr9.cursomc.modelo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.brunobr9.cursomc.exceptions.ServiceException;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidade abstrata que mapeia outras entidades que possuem ID
 * 
 * @author Bruno Henrique
 * @since 0.1
 */
@Getter
@Setter
@MappedSuperclass
public abstract class IdLongMapped implements IdEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Atributo ID
     */
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Realiza validações antes de inserir o objeto
     */
    @Override
    public void checkBeforeInsert() throws ServiceException {
	if (id != null) {
	    throw new ServiceException("Não é possivel inserir objeto com id valido!");
	}
    }

    /**
     * Realiza validações antes de atualizar o objeto
     */
    @Override
    public void checkBeforeUpdate() throws ServiceException {
    }

    /**
     * Realiza validações antes de deletar o objeto
     */
    @Override
    public void checkBeforeDelete() throws ServiceException {
    }

}
