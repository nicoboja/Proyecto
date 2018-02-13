package controlers;

import entity.Usuario;

import java.util.ArrayList;

import data.DataUsuario;

public class CtrlABMUsuario {
	
	private DataUsuario dataU = new DataUsuario();
	
	
	public void add(Usuario u) throws Exception{		
		dataU.add(u);		
	}
	
	public void delete(Usuario u) throws Exception{	
		dataU.delete(u);		
	}
	
	public void update(Usuario u) throws Exception{			
		dataU.update(u);					
	}					
	
	public Usuario login(Usuario u) throws Exception{		
		Usuario us=new Usuario();
		us=null;
		us=dataU.getLogedUser(u);
		if (us!=null){
			us.setNivel(dataU.getNivelesUser(us));
			//System.out.println(us.getNivel().get(0).getDescripcion());
		}		
		return us;
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


}
