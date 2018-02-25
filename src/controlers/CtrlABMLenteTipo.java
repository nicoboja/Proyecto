package controlers;

import java.util.ArrayList;

import data.DataLenteTipo;
import entity.LenteTipo;

public class CtrlABMLenteTipo {

	DataLenteTipo dataTipo=new DataLenteTipo();
	
	public LenteTipo getById(LenteTipo lt) throws Exception{
		return this.dataTipo.getById(lt);		
	}
	
	public ArrayList<LenteTipo> getAll()throws Exception{
		return dataTipo.getAll();
	}
}

