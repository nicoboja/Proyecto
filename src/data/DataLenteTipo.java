package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.LenteTipo;
import util.AppDataException;

public class DataLenteTipo {

	public LenteTipo getById(LenteTipo lt) throws AppDataException {
		LenteTipo t=new LenteTipo();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from lentetipo where idTipo=?");
			stmt.setInt(1, lt.getIdTipo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				t = new LenteTipo();
				t.setIdTipo(rs.getInt("idTipo"));
				t.setDescripcion(rs.getString("descripcion"));
				}			
		}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar Tipos de Lentes de la BD");
				
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return t;
	}
	
	public ArrayList<LenteTipo> getAll() throws AppDataException {
		LenteTipo t = null;
		Statement stmt=null;
		ResultSet rs=null;		
		ArrayList<LenteTipo> lenTipos= new ArrayList<LenteTipo>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from paciente");
			if(rs!=null){
				while(rs.next()){
					t = new LenteTipo();
					t.setIdTipo(rs.getInt("idTipo"));
					t.setDescripcion(rs.getString("descripcion"));
					lenTipos.add(t);
				}
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar Pacientes de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return lenTipos;
	}
}