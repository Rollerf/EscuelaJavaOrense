package com.vn.ejemplospring.demospring.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**	@Entity, @Id, @... Decoradores (
 * 
 * @author pc
 *
 */
@Entity	// JPA: Java Persintence Api
public class CuentaBanc extends Object implements Serializable {
	// JPA: Java Persintence Api
	@Id		
	// El campo es autoincremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 1, max = 16)
	@NotNull
	private String iban;
	
	// @Required	
	private String dni;
	
	// El contructor por defecto es necesario porque
	// Hibernate (junto JPA) necesita poder construir el objeto
	// y luego mapear las propiedades en tablas
	public CuentaBanc() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		
		return "CuentaBanc [id=" + id + ", iban=" + iban + ", dni=" + dni + "]";
	}

	
}
