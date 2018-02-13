package controlers;

import data.DataFichaLente;
import entity.FichaLente;

public class CtrlABMFichaLente {
	private DataFichaLente dataFicLen = new DataFichaLente();

	
	public void add(FichaLente fl) throws Exception{		
		dataFicLen.add(fl);		
	}
	
	public void delete(FichaLente fl) throws Exception{	
		dataFicLen.delete(fl);		
	}
	
	public void update(FichaLente fl) throws Exception{			
		dataFicLen.update(fl);					
	}			
	
	public FichaLente getById(FichaLente fl) throws Exception{	
		return this.dataFicLen.getById(fl);			
	}
}
