package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.LenteMaterial;
import util.AppDataException;

public class DataLenteMaterial {

	public LenteMaterial getById(LenteMaterial lm) throws AppDataException {
		LenteMaterial mat = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from lentematerial where idMaterial=?");
			stmt.setInt(1, lm.getIdMaterial());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				mat = new LenteMaterial();
				mat.setIdMaterial(rs.getInt("idMaterial"));
				mat.setDescripcion(rs.getString("descripcion"));
				}			
		}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar Materiales de Lentes de la BD");
				
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return mat;
	}
	
	public ArrayList<LenteMaterial> getAll() throws AppDataException {
		LenteMaterial mat = null;
		Statement stmt=null;
		ResultSet rs=null;		
		ArrayList<LenteMaterial> lenMat= new ArrayList<LenteMaterial>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from paciente");
			if(rs!=null){
				while(rs.next()){
					mat = new LenteMaterial();
					mat.setIdMaterial(rs.getInt("idMaterial"));
					mat.setDescripcion(rs.getString("descripcion"));
					lenMat.add(mat);
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
		return lenMat;
	}
}