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

	public Usuario getLogedUser(Usuario u) throws AppDataException {
		Usuario uLog = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		PreparedStatement stmtn=null;
		ResultSet rsn=null;
		
		
		ArrayList<Nivel> uNiv= new ArrayList<Nivel>();
		
		System.out.println(u.getUser()+" HOLA "+u.getPass());
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from usuario where user=? and pass=?");
			stmt.setString(1, u.getUser());
			stmt.setString(2, u.getPass());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				uLog = new Usuario();
				uLog.setNombre(rs.getString("nombre"));
				uLog.setApellido(rs.getString("apellido"));
				uLog.setCorreo(rs.getString("correo"));
				uLog.setFecAlta(rs.getString("fecalta"));
				uLog.setFecEstado(rs.getString("fecestado"));
				uLog.setEstado(rs.getString("estado"));
				
				//Cargo Niveles del Usuario
				try {
					stmtn=FactoryConexion.getInstancia().getConn().prepareStatement(
							"select * from nivel n inner join nivel_usuario nu on  n.idnivel = nu.idnivel where nu.`idUsuario` = ?");
				stmtn.setString(1, u.getUser());
				rsn=stmtn.executeQuery();
					if(rsn!=null && rsn.next()){
						Nivel niv = new Nivel();
						niv.setIdNivel(rs.getInt("idNiv"));
						niv.setDescripcion(rs.getString("desc"));
						uNiv.add(niv);
					}
				} catch (SQLException | AppDataException e) {
					throw new AppDataException(e,"No es posible recuperar nivel de usuario");
				}
				
				}			
			}catch (SQLException | AppDataException e) {
				throw new AppDataException(e,"No es posible recuperar usuario");
				
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


