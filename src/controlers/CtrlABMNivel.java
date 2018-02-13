package controlers;

import java.util.ArrayList;

import data.DataNivel;
import entity.Nivel;


public class CtrlABMNivel {
	
	private DataNivel dataN = new DataNivel();
	
	public ArrayList<Nivel> getAll() throws Exception {		
		
			return dataN.getAll();		
		
	}

}