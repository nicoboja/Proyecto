package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Nivel;
import entity.Usuario;
import util.AppDataException;

public class DataUsuario {

	public void add(Usuario u) throws AppDataException{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into usuario (apellido, correo, nombre, pass, user, fecalta, estado) values (?,?,?,?,?,CURDATE(),'Habilitado')");	
			stmt.setString(1,u.getApellido());
			stmt.setString(2, u.getCorreo());
			stmt.setString(3, u.getNombre());
			stmt.setString(4, u.getPass());
			stmt.setString(5, u.getUser());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible agregar Usuario a la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 		
	}		

	public void delete(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	public void update(Usuario u) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"update usuario set apellido=?, correo=?, nombre=?, pass=?, estado=?, fecEstado=? where idU=?;");
			stmt.setString(1,u.getApellido());
			stmt.setString(2, u.getCorreo());
			stmt.setString(3, u.getNombre());
			stmt.setString(4, u.getPass());
			stmt.setString(5, u.getUser());
			stmt.setInt(6, u.getIdU());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar Usuario en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 			
	}

	public Usuario getByUser(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Nivel> getNivelesUser(Usuario u) throws AppDataException{
		ArrayList<Nivel> niveles = null;
		Nivel n=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select * from nivel_usuario nu inner join nivel n on nu.idnivel=n.idnivel where nu.idusuario=?");
			stmt.setInt(1, u.getIdU());			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				n = new Nivel();
				n.setIdNivel(rs.getInt("nu.idnivel"));
				n.setDescripcion(rs.getString("n.descripcion"));	
				
				}			
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar niveles de usuario de la BD");
				
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


