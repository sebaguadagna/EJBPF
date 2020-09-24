package com.entities;

import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.*;


@Entity
@Table(name = "OBSERVACIONES")
public class Observacion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqObservacion", initialValue=1, sequenceName="SEQ_ID_OBSERVACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqObservacion")
	private Long id_observacion;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_voluntario_observacion"))
	private Usuario usr_voluntario;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaHora;
	
	@Column(length = 200)
	private  String descripcion;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_fenomeno_observacion"))
	private Fenomeno categoria;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_localidad_observacion"))
	private Localidad localidad;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_experto_observacion"))
	private Usuario usr_experto;
	
	private boolean validarExperto;
	
	private String coordenadas;
	
	private String imagen;
	
	
	public String getCoordenadas() {
		return coordenadas;
	}


	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Long getId_observacion() {
		return id_observacion;
	}


	public void setId_observacion(Long id_observacion) {
		this.id_observacion = id_observacion;
	}


	public Usuario getUsr_voluntario() {
		return usr_voluntario;
	}


	public void setUsr_voluntario(Usuario usr_voluntario) {
		this.usr_voluntario = usr_voluntario;
	}


	public Usuario getUsr_experto() {
		return usr_experto;
	}


	public void setUsr_experto(Usuario usr_experto) {
		this.usr_experto = usr_experto;
	}


	public Calendar getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(Calendar fechaHora) {
		this.fechaHora = fechaHora;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Fenomeno getCategoria() {
		return categoria;
	}


	public void setCategoria(Fenomeno categoria) {
		this.categoria = categoria;
	}



	public Localidad getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}



	public boolean isValidarExperto() {
		return validarExperto;
	}


	public void setValidarExperto(boolean validarExperto) {
		this.validarExperto = validarExperto;
	}
	
	
}