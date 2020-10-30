package com.dto;

import java.io.Serializable;
import java.util.Date;



public class ObservacionDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id_observacion;
	
	private String emailVoluntario;
	
	private Date fecha;
	
	private String descripcion;
	
	private String categoriaFenomeno;
	
	private String Localidad;
	
	private String emialExperto;
	
	private double latitud;
	
	private double longitud;
	
	private byte[] imagen;
	
	private String departamento;
	
	private boolean validarExperto;
	
	
	public Long getId_observacion() {
		return id_observacion;
	}

	public void setId_observacion(Long id_observacion) {
		this.id_observacion = id_observacion;
	}

	public String getEmailVoluntario() {
		return emailVoluntario;
	}

	public void setEmailVoluntario(String emailVoluntario) {
		this.emailVoluntario = emailVoluntario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoriaFenomeno() {
		return categoriaFenomeno;
	}

	public void setCategoriaFenomeno(String categoriaFenomeno) {
		this.categoriaFenomeno = categoriaFenomeno;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getEmialExperto() {
		return emialExperto;
	}

	public void setEmialExperto(String emialExperto) {
		this.emialExperto = emialExperto;
	}

	


	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public boolean isValidarExperto() {
		return validarExperto;
	}

	public void setValidarExperto(boolean validarExperto) {
		this.validarExperto = validarExperto;
	}

	

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	
	
	

}
