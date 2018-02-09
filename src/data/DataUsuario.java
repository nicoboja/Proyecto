package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Nivel;
import entity.Usuario;
import util.AppDataException;

public class DataUsuario {

	public void add(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	public void update(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	public Usuario getByUser(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Nivel> getNivelesUser(Usuario u) throws AppDataException{
		ArrayList<Nivel> niveles = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from nivel n inner where user=? and pass=?");
			stmt.setInt(1, u.getIdU());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				Nivel n = new Nivel();
				
				}			
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar usuario de la BD");
				
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

	public Usuario getLogedUser(Usuario u) throws AppDataException {
		Usuario uLog = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		System.out.println(u.getUser()+" <<-->> "+u.getPass());
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from usuario where user=? and pass=?");
			stmt.setString(1, u.getUser());
			stmt.setString(2, u.getPass());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				uLog = new Usuario();
				uLog.setNombre(rs.getString("nombre"));
				uLog.setUser(rs.getString("user"));
				uLog.setApellido(rs.getString("apellido"));
				uLog.setCorreo(rs.getString("correo"));
				uLog.setFecAlta(rs.getString("fecalta"));
				uLog.setFecEstado(rs.getString("fecestado"));
				uLog.setEstado(rs.getString("estado"));
				uLog.setIdU(rs.getInt("idU"));
				}			
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar usuario de la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
			return uLog;
		}
	
	}


