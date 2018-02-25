package controlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import data.DataFichaLente;
import entity.FichaLente;
import entity.Paciente;

public class CtrlABMFichaLente {
	private DataFichaLente dataFicLen = new DataFichaLente();

	
	public void add(FichaLente fl) throws Exception{	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		fl.setFecEntrada(dtf.format(localDate));
		fl.setFecEstado(dtf.format(localDate));
		fl.setEstado("Nuevo");
		dataFicLen.add(fl);		
	}
	
	public void delete(FichaLente fl) throws Exception{	
		dataFicLen.delete(fl);		
	}
	
	public void update(FichaLente fl) throws Exception{			
		dataFicLen.update(fl);					
	}			
	
	public FichaLente getById(FichaLente fl) throws Exception{	
		return dataFicLen.getById(fl);			
	}
	
	public ArrayList<FichaLente> getByEstado(String est) throws Exception{
		return dataFicLen.getByEstado(est);		
	}
	
	public int getCantEstado(String est)throws Exception{		
		return dataFicLen.getCantEstado(est);			
	}
	
	public ArrayList<FichaLente> getByPaciente(Paciente pac)throws Exception{
		return dataFicLen.getByPaciente(pac);		
	}
	
	public void cambiarEstado(FichaLente fl) throws Exception{	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		fl.setFecEstado(dtf.format(localDate));
		dataFicLen.cambiarEstado(fl);					
	}		

}