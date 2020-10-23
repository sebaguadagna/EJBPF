package com.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.daos.FenomenoDAO;
import com.daos.LocalidadDAO;
import com.daos.ObservacionDAO;
import com.daos.UsuarioDAO;
import com.dto.LocalidadDTO;
import com.dto.ObservacionDTO;
import com.entities.Localidad;
import com.entities.Observacion;
import com.entities.Usuario;
import com.enumerados.EnumNombreDepartamento;
import com.exception.ServiciosException;

@LocalBean
@Stateless
public class GestionObservacionBean implements IGestionObservacionBean {
	
	@EJB
	private FenomenoDAO fPersistencia;
	
	@EJB
	private LocalidadDAO localidadPersistencia;
	
	@EJB
	private ObservacionDAO observacionPersistencia;
	
	@EJB
	private UsuarioDAO usuarioPersistencia;
	
	private List<LocalidadDTO> prepararLocalidades(String nombreDepartamento) throws ServiciosException{
		
		List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		
		EnumNombreDepartamento dpto = null;
		
		for(EnumNombreDepartamento d : EnumNombreDepartamento.values()) {
			if(d.name().equals(nombreDepartamento)) { 
				dpto = d;
				break;
			}
		}
		
		for(Localidad l : localidadPersistencia.obtenerLocalidadesPorDepartamento(dpto)) {
			LocalidadDTO lo = new LocalidadDTO();
			lo.setNombre(l.getNombre());
			localidades.add(lo);
		}
		
		return localidades;
		
	}
	
	private Observacion prepararObservacion(ObservacionDTO observacionDTO) throws ServiciosException{
		Observacion o = new Observacion();
		Usuario u = new Usuario();
		EnumNombreDepartamento nombreDepartamento = null;
		Localidad l = new Localidad();
		
		o.setValidarExperto(false);
		o.setCategoria(fPersistencia.obtenerPorNombre(observacionDTO.getCategoriaFenomeno()).get(0));
		o.setDescripcion(observacionDTO.getDescripcion());
		System.out.print(observacionDTO.getFecha());
		o.setFecha(observacionDTO.getFecha());
		
		for(EnumNombreDepartamento d : EnumNombreDepartamento.values()) {
			if(d.name().equals(observacionDTO.getDepartamento())) {
				nombreDepartamento = d;
			}
		}
		l = localidadPersistencia.obtenerLocalidadesIdDosFiltros(nombreDepartamento, 
				observacionDTO.getLocalidad()).get(0);
		o.setLocalidad(l);
		u = usuarioPersistencia.obtenerPorEmail(observacionDTO.getEmailVoluntario()).get(0);
		o.setUsr_voluntario(u);
		o.setLatitud(observacionDTO.getLatitud());
		o.setLongitud(observacionDTO.getLongitud());
		return o;
			
	}
	
	
	@Override
	public void agregarObservacion(ObservacionDTO observacionDTO) throws ServiciosException {
		observacionPersistencia.altaObservacion(prepararObservacion(observacionDTO));
		
	}

	@Override
	public void actualizarObservacion(ObservacionDTO observacionDTO) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocalidadDTO> obtenerLocalidadesPorDepartamento(String nombreDepartamento) throws ServiciosException {
		return prepararLocalidades(nombreDepartamento);
	}

	
	

}
