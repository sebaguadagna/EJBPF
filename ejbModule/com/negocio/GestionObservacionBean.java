package com.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.daos.ObservacionDAO;
import com.dto.ObservacionDTO;
import com.entities.Observacion;
import com.exception.ServiciosException;

@LocalBean
@Stateless
public class GestionObservacionBean implements IGestionObservacionBean {

	
	@EJB
	ObservacionDAO oPersistencia;
	
	public GestionObservacionBean() {
    }
	
	@Override
	public void agregarObservacion(ObservacionDTO observacionDTO) throws ServiciosException {
		prepararObservacion(observacionDTO);
	}
	
	@Override
	public List<ObservacionDTO> obtenerObservaciones() throws ServiciosException{
		return prepararTodosLasObservaciones();
	}
	
	
	public List<ObservacionDTO> prepararTodosLasObservaciones() throws ServiciosException{
    	
    	List<Observacion> obs = oPersistencia.obtenerTodos();
		List<ObservacionDTO> obsDTO= new ArrayList<ObservacionDTO>();
		

		for(Observacion o : obs) {			
			ObservacionDTO obDTO = new ObservacionDTO();
			obDTO.setCoordenadas(o.getCoordenadas());
			obDTO.setDescripcion(o.getDescripcion());
			obDTO.setFechahora(o.getFechaHora());
		
//			System.out.println("CODIGO " + o.getCodigo());
//			obDTO.setNombre(o.getNombre());
//			obDTO.setDescripcion(o.getDescripcion());
//			obDTO.setTelefono(o.getTelefono());
			
			obsDTO.add(obDTO);
		}
		return obsDTO;	
    }
	

   
    public Observacion prepararObservacion(ObservacionDTO observacionDTO) throws ServiciosException {
    	
    	Observacion observacionAdd = new Observacion();
    	
    	//if(observacionDTO.getCodigo() != null ) observacionAdd.setCodigo(observacionDTO.getCodigo());
    	observacionAdd.setCoordenadas(observacionDTO.getCoordenadas());
    	observacionAdd.setDescripcion(observacionDTO.getDescripcion());
    	observacionAdd.setImagen(observacionDTO.getImagen());
    	
    	observacionAdd.setValidarExperto(true);
			
		
		return observacionAdd;
    }
    
//    
//    public List<FenomenoDTO> prepararTodosLosFenomenos() throws ServiciosException{
//    	
//    	List<Fenomeno> feno = fPersistencia.obtenerTodos();
//		List<FenomenoDTO> fenoDTO= new ArrayList<FenomenoDTO>();
//		
//
//		for(Fenomeno f : feno) {			
//			FenomenoDTO fenDTO = new FenomenoDTO();
//			fenDTO.setCodigo(f.getCodigo());
//			System.out.println("CODIGO " + f.getCodigo());
//			fenDTO.setNombre(f.getNombre());
//			fenDTO.setDescripcion(f.getDescripcion());
//			fenDTO.setTelefono(f.getTelefono());
//			
//			fenoDTO.add(fenDTO);
//		}
//		return fenoDTO;	
//    }
//    
//    public Fenomeno prepararBajaFenomeno(String codigo) throws ServiciosException {
//    	Fenomeno fe = fPersistencia.obtenerPorNombre(codigo).get(0);
//    	fe.setCodigo(codigo);
//		return fe;
//    	
//    }
//    
//    public FenomenoDTO prepararFenomenoCodigo(String codigo) throws ServiciosException{
//    	
//    	FenomenoDTO fdto = new FenomenoDTO();
//    	
//    	if(!fPersistencia.obtenerPorNombre(codigo).isEmpty()) {
//    		Fenomeno f = fPersistencia.obtenerPorNombre(codigo).get(0);
//    		fdto.setCodigo(f.getCodigo());
//    		fdto.setDescripcion(f.getDescripcion());
//    		fdto.setNombre(f.getNombre());
//    		fdto.setTelefono(f.getTelefono());
//    		return fdto;
//    	}
//    	return null;
//    }
//    
//    
//    /*
//     * Servicios para la REST y JSF
//     */
//    
//	@Override
//	public void agregarFenomeno(FenomenoDTO fenomenoDTO) throws  ServiciosException  {		
//		fPersistencia.altaFenomeno(this.prepararFenomeno(fenomenoDTO));
//	}
//
//	
//	
//	@Override
//	public void modificarFenomeno(FenomenoDTO fenomenoDTO) throws  ServiciosException  {
//		fPersistencia.modificarFenomeno(this.prepararFenomeno(fenomenoDTO));
//	}
//
//	@Override
//	public FenomenoDTO obtenerFenomenoNombre(String nombre) throws  ServiciosException{
//		return this.prepararFenomenoCodigo(nombre);
//	};
//	
//	@Override
//	public List<FenomenoDTO> obtenerFenomenos() throws ServiciosException {
//		List<FenomenoDTO> fs = this.prepararTodosLosFenomenos();
//		return fs;
//	}
//
//
//	@Override
//	public void bajaFenomeno(String fenomeno) throws ServiciosException {
//		// TODO Auto-generated method stub
//		
//	}


//	@Override
//	public FenomenoDTO obtenerFenomeno(FenomenoDTO fenomeno) throws ServiciosException {
//		return prepararFenomeno();
//	}
}