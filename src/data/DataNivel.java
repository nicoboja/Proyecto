package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Nivel;
import util.AppDataException;

public class DataNivel {

	public ArrayList<Nivel> getAll() throws AppDataException {
		ArrayList<Nivel> niveles = new ArrayList <Nivel>();
		Nivel n=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select * from nivel");		
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					n = new Nivel();
					n.setIdNivel(rs.getInt("idnivel"));
					n.setDescripcion(rs.getString("descripcion"));	
					niveles.add(n);
					}		
				}	
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar Niveles de la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
		return niveles;
	}

}