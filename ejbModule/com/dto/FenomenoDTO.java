package com.dto;

import java.io.Serializable;


public class FenomenoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private String telefono;
	
	
	public FenomenoDTO() {
		
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
}
