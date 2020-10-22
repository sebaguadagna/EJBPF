package com.dto;

import java.io.Serializable;
import java.util.List;


public class FenomenoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id_fenomeno;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String telefono;
	private List<CaracteristicaDTO> crcl; 
	
	
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


	public List<CaracteristicaDTO> getCrcl() {
		return crcl;
	}


	public void setCrcl(List<CaracteristicaDTO> crcl) {
		this.crcl = crcl;
	}


	public Long getId_fenomeno() {
		return id_fenomeno;
	}


	public void setId_fenomeno(Long id_fenomeno) {
		this.id_fenomeno = id_fenomeno;
	}

	
	
}
