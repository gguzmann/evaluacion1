package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="regalos")
public class Regalo {

	// ATTRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private Long id;

	@Size(min=6, max=9)
	private String destinatario;
	private String origen;
	private String nombre;
	
	private Integer telefono;
	
	// CONSTRUCTORES VACIO Y CON PARAMETROS
	
	public Regalo() {
		super();
	}

	public Regalo(Long id, String destinatario, String origen, String nombre) {
		super();
		this.id = id;
		this.destinatario = destinatario;
		this.origen = origen;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
	// GETTER & SETTER
	
	
	
}
