package controlers;

import java.util.ArrayList;

import data.DataLenteMaterial;
import entity.LenteMaterial;

public class CtrlABMLenteMaterial {
	DataLenteMaterial dataMat=new DataLenteMaterial();
	
	public LenteMaterial getById(LenteMaterial lm) throws Exception{
		return dataMat.getById(lm);		
	}
	
	public ArrayList<LenteMaterial> getAll()throws Exception{
		return dataMat.getAll();
	}

}
