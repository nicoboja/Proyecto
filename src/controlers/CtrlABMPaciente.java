package controlers;

import java.util.ArrayList;

import data.DataPaciente;
import entity.Paciente;

public class CtrlABMPaciente {

	private DataPaciente dataPac = new DataPaciente();

	
	public void add(Paciente pac) throws Exception{	
		Paciente pa=new Paciente();
		pa=this.getByDoc(pac);		
		if(pa==null){
			dataPac.add(pac);
		}
	}
	
	public void delete(Paciente pac) throws Exception{	
		dataPac.delete(pac);		
	}
	
	public void update(Paciente pac) throws Exception{			
		dataPac.update(pac);					
	}			
	
	public Paciente getById(Paciente pac) throws Exception{	
		return this.dataPac.getById(pac);			
	}
	
	public ArrayList<Paciente> getAll() throws Exception{	
		return this.dataPac.getAll();		
	}
	
	public Paciente getByDoc(Paciente pac) throws Exception{	
		return this.dataPac.getByDoc(pac);			
	}
	
	public ArrayList<Paciente> getByApe(Paciente pac) throws Exception{	
		return this.dataPac.getByApe(pac);			
	}

	public ArrayList<Paciente> getListDoc(Paciente pac) throws Exception{	
		return this.dataPac.getListDoc(pac);		
	}
	
	public ArrayList<Paciente> getListHC(Paciente pac) throws Exception{	
		return this.dataPac.getListHC(pac);		
	}

}
