package com.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.entities.Usuario;

public class ObservacionDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long   id_observacion;
	private String coordenadas;
	private String descripcion;
	private Calendar fechahora;
	private String imagen;
	private Usuario validarexperto;
	private String categoria_id_fenomeno;
	private String localidad_id_localidad;
	private String usr_experto_id_usuario;
	private String usr_voluntario_id_usuario;
	
	
	public ObservacionDTO() {
		
	}

	public Long getId_observacion() {
		return id_observacion;
	}

	public void setId_observacion(Long id_observacion) {
		this.id_observacion = id_observacion;
	}


	public String getCoordenadas() {
		return coordenadas;
	}


	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Calendar getFechahora() {
		return fechahora;
	}


	public void setFechahora(Calendar fechahora) {
		this.fechahora = fechahora;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Usuario getValidarexperto() {
		return validarexperto;
	}


	public void setValidarexperto(Usuario validarexperto) {
		this.validarexperto = validarexperto;
	}


	public String getCategoria_id_fenomeno() {
		return categoria_id_fenomeno;
	}


	public void setCategoria_id_fenomeno(String categoria_id_fenomeno) {
		this.categoria_id_fenomeno = categoria_id_fenomeno;
	}


	public String getLocalidad_id_localidad() {
		return localidad_id_localidad;
	}


	public void setLocalidad_id_localidad(String localidad_id_localidad) {
		this.localidad_id_localidad = localidad_id_localidad;
	}


	public String getUsr_experto_id_usuario() {
		return usr_experto_id_usuario;
	}


	public void setUsr_experto_id_usuario(String usr_experto_id_usuario) {
		this.usr_experto_id_usuario = usr_experto_id_usuario;
	}


	public String getUsr_voluntario_id_usuario() {
		return usr_voluntario_id_usuario;
	}


	public void setUsr_voluntario_id_usuario(String usr_voluntario_id_usuario) {
		this.usr_voluntario_id_usuario = usr_voluntario_id_usuario;
	}


	
}