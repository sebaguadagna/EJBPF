package com.negocio;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;

import com.dto.ObservacionDTO;
//import com.dto.UsuarioDTO;
//import com.dto.UsuarioDTO;
import com.exception.ServiciosException;

@Local
public interface IGestionObservacionBean {

	public void agregarObservacion(ObservacionDTO observacionDTO) throws ServiciosException;
	public List<ObservacionDTO> obtenerObservaciones() throws ServiciosException;
}


