package com.negocio;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Local;

import com.dto.FenomenoDTO;
import com.exception.ServiciosException;

@Local
public interface IGestionFenomenoBean {
	
	public void agregarFenomeno(FenomenoDTO fenomenoDTO) throws ServiciosException, NoSuchAlgorithmException;
	public void modificarFenomeno(FenomenoDTO fenomenoDTO) throws  NoSuchAlgorithmException, ServiciosException;
	public List<FenomenoDTO> obtenerFenomenos() throws ServiciosException;
	public void bajaFenomeno(String fenomeno) throws  ServiciosException;

}
