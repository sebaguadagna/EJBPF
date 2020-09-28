package com.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.daos.FenomenoDAO;
import com.dto.FenomenoDTO;
import com.entities.Fenomeno;
import com.exception.ServiciosException;

@LocalBean
@Stateless
public class GestionFenomenoBean implements IGestionFenomenoBean {

	@EJB
	FenomenoDAO fPersistencia;
	
	public GestionFenomenoBean() {
    }

   
    public Fenomeno prepararFenomeno(FenomenoDTO fenomenoDTO) throws ServiciosException {
    	
    	Fenomeno fenomenoAdd = new Fenomeno();
    	
    	if(fenomenoDTO.getCodigo() != null ) fenomenoAdd.setCodigo(fenomenoDTO.getCodigo());
		fenomenoAdd.setCodigo(fenomenoDTO.getCodigo());
		fenomenoAdd.setNombre(fenomenoDTO.getNombre());
    	fenomenoAdd.setDescripcion(fenomenoDTO.getDescripcion());
    	fenomenoAdd.setTelefono(fenomenoDTO.getTelefono());
			
		
		return fenomenoAdd;
    }
    
    
    public List<FenomenoDTO> prepararTodosLosFenomenos() throws ServiciosException{
    	
    	List<Fenomeno> feno = fPersistencia.obtenerTodos();
		List<FenomenoDTO> fenoDTO= new ArrayList<FenomenoDTO>();
		

		for(Fenomeno f : feno) {			
			FenomenoDTO fenDTO = new FenomenoDTO();
			fenDTO.setCodigo(f.getCodigo());
			System.out.println("CODIGO " + f.getCodigo());
			fenDTO.setNombre(f.getNombre());
			fenDTO.setDescripcion(f.getDescripcion());
			fenDTO.setTelefono(f.getTelefono());
			
			fenoDTO.add(fenDTO);
		}
		return fenoDTO;	
    }
    
    public Fenomeno prepararBajaFenomeno(String codigo) throws ServiciosException {
    	Fenomeno fe = fPersistencia.obtenerPorNombre(codigo).get(0);
    	fe.setCodigo(codigo);
		return fe;
    	
    }
    
    public FenomenoDTO prepararFenomenoCodigo(String codigo) throws ServiciosException{
    	
    	FenomenoDTO fdto = new FenomenoDTO();
    	
    	if(!fPersistencia.obtenerPorNombre(codigo).isEmpty()) {
    		Fenomeno f = fPersistencia.obtenerPorNombre(codigo).get(0);
    		fdto.setCodigo(f.getCodigo());
    		fdto.setDescripcion(f.getDescripcion());
    		fdto.setNombre(f.getNombre());
    		fdto.setTelefono(f.getTelefono());
    		return fdto;
    	}
    	return null;
    }
    
    
    /*
     * Servicios para la REST y JSF
     */
    
	@Override
	public void agregarFenomeno(FenomenoDTO fenomenoDTO) throws  ServiciosException  {		
		fPersistencia.altaFenomeno(this.prepararFenomeno(fenomenoDTO));
	}

	
	
	@Override
	public void modificarFenomeno(FenomenoDTO fenomenoDTO) throws  ServiciosException  {
		fPersistencia.modificarFenomeno(this.prepararFenomeno(fenomenoDTO));
	}

	@Override
	public FenomenoDTO obtenerFenomenoNombre(String nombre) throws  ServiciosException{
		return this.prepararFenomenoCodigo(nombre);
	};
	
	@Override
	public List<FenomenoDTO> obtenerFenomenos() throws ServiciosException {
		List<FenomenoDTO> fs = this.prepararTodosLosFenomenos();
		return fs;
	}


	@Override
	public void bajaFenomeno(String fenomeno) throws ServiciosException {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public FenomenoDTO obtenerFenomeno(FenomenoDTO fenomeno) throws ServiciosException {
//		return prepararFenomeno();
//	}
	
}
