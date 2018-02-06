package controlers;

import data.DataPaciente;
import entity.Paciente;

public class CtrlABMPaciente {

	private DataPaciente dataPac = new DataPaciente();

	
	public void add(Paciente pac) throws Exception{		
		dataPac.add(pac);		
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

}
