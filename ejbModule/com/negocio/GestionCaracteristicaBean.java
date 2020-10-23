package com.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.daos.CaracteristicaDAO;
import com.daos.FenomenoDAO;
import com.dto.CaracteristicaDTO;
import com.entities.Caracteristica;
import com.enumerados.EnumTipoDatoCaracteristica;
import com.exception.ServiciosException;


@LocalBean
@Stateless
public class GestionCaracteristicaBean implements IGestionCaracteristicaBean {

	@EJB
	private CaracteristicaDAO cPersistencia;
	
	@EJB
	private FenomenoDAO fPersistencia;
	
	private Caracteristica prepararAgregarCaracteristica(CaracteristicaDTO crc) throws ServiciosException {
		Caracteristica c = new Caracteristica();
		
		c.setNombre(crc.getNombre());
		c.setEtiqueta(crc.getEtiqueta());
		
		for(EnumTipoDatoCaracteristica tdc:EnumTipoDatoCaracteristica.values()) {
			if(tdc.toString().equalsIgnoreCase(crc.getTipoDato())) {
				c.setTipoDato(tdc);
				break;
			}
		}
		
		c.setFenomeno(fPersistencia.obtenerPorNombre(crc.getFenomeno()).get(0));
		return c;
	} 
	
	
	@Override
	public void agregarCaracteristica(CaracteristicaDTO caracteristicaDTO) throws ServiciosException {
		cPersistencia.altaCaracteristica(this.prepararAgregarCaracteristica(caracteristicaDTO));
		
	}

	@Override
	public void modificarFenomeno(CaracteristicaDTO caracteristicaDTO) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CaracteristicaDTO> obtenerCaracteristicas() throws ServiciosException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
