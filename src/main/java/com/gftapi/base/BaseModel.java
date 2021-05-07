package com.gftapi.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Data de Criação:05/05/2021
 * @author endr
 * @version 1.0
 */
@MappedSuperclass
public class BaseModel implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3364233331358716105L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	@JsonIgnore
	protected Long version;
	
	@Column(name = "dt_criacao", updatable = false)
	@JsonIgnore
	protected LocalDateTime dataCriacao;
	
	@Column(name = "dt_atualizacao")
	@JsonIgnore
	protected LocalDateTime dataAtualizacao;
	

	/**
	 * Recupera o atributo 'id'
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * preenche o atributo 'id'
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Recupera o atributo 'dataCriacao'
	 * 
	 * @return
	 */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * preenche o atributo 'dataCriacao'
	 */
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * Recupera o atributo 'dataAtualizacao'
	 * 
	 * @return
	 */
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	/**
	 * preenche o atributo 'dataAtualizacao'
	 */
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
