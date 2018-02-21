package controlers;

import entity.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import data.DataUsuario;

public class CtrlABMUsuario {

	private DataUsuario dataU = new DataUsuario();
		
	public boolean add(Usuario u) throws Exception{
		boolean b=false;

		if(dataU.existeUser(u)==false){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			u.setFecAlta((dtf.format(localDate)));
			u.setFecEstado((dtf.format(localDate)));
			dataU.add(u);	
			if(u.getNivel()!=null){
				dataU.insertNivUser(u);
			}				
			b=true;
		}
		return b;
	}
	
	public void delete(Usuario u) throws Exception{	
		dataU.delete(u);		
	}
	
	public void update(Usuario u) throws Exception{		
		Usuario uvalida=new Usuario();
		uvalida=this.getById(u);
		if(uvalida.getEstado()==u.getEstado()){
			u.setFecEstado(uvalida.getFecEstado());	
		}else{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			u.setFecEstado((dtf.format(localDate)));
		}
		dataU.update(u);
		if(u.getNivel()!=null){
			dataU.deleteNivUser(u);
			dataU.insertNivUser(u);
		}		
	}					
		
	
	public Usuario login(Usuario u) throws Exception{		
		return this.dataU.getLogedUser(u);
	}
	
	public Usuario recuperarNiveles(Usuario u) throws Exception{
		Usuario us=new Usuario();
		us.setNivel(dataU.getNivelesUser(u));
		return us;
	}
	
	public Usuario getByUser(Usuario u) throws Exception{	
		return this.dataU.getByUser(u);			
	}

	public ArrayList<Usuario> getAll() throws Exception{	
		return this.dataU.getAll();		
	}
	
	public Usuario getById(Usuario u) throws Exception{
		return this.dataU.getById(u);
	}
}
