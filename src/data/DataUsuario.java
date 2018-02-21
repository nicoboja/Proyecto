package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Nivel;
import entity.Usuario;
import util.AppDataException;

public class DataUsuario {

	public void add(Usuario u) throws AppDataException{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into usuario (user, apellido, correo, nombre, pass, notas, estado, fecalta, fecestado)"
						+ " values (?,?,?,?,?,?,?,?,?)");	

			stmt.setString(1, u.getUser());
			stmt.setString(2, u.getApellido());
			stmt.setString(3, u.getCorreo());
			stmt.setString(4, u.getNombre());
			stmt.setString(5, u.getPass());			
			stmt.setString(6, u.getNotas());
			stmt.setString(7, u.getEstado());
			stmt.setString(8, u.getFecAlta());
			stmt.setString(9, u.getFecEstado());
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
						"update usuario set apellido=?, correo=?, nombre=?, pass=?, estado=?, fecEstado=?,"
						+ " notas=? where idU=?;");
			stmt.setString(1, u.getApellido());
			stmt.setString(2, u.getCorreo());
			stmt.setString(3, u.getNombre());
			stmt.setString(4, u.getPass());
			stmt.setString(5, u.getEstado());
			stmt.setString(6, u.getFecEstado());
			stmt.setString(7, u.getNotas());
			stmt.setInt(8, u.getIdU());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar Usuario en la BD DATOS");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 			
	}

	public Usuario getByUser(Usuario u) throws AppDataException {
		Usuario usu = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from usuario where user=?");
			stmt.setString(1, u.getUser());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				usu = new Usuario();
				usu.setNombre(rs.getString("nombre"));
				usu.setUser(rs.getString("user"));
				usu.setApellido(rs.getString("apellido"));
				usu.setCorreo(rs.getString("correo"));
				usu.setFecAlta(rs.getString("fecalta"));
				usu.setFecEstado(rs.getString("fecestado"));
				usu.setEstado(rs.getString("estado"));
				usu.setIdU(rs.getInt("idU"));
				usu.setNotas(rs.getString("notas"));
				usu.setNivel(this.getNivelesUser(usu));
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
		return usu;
	}
	
	public ArrayList<Nivel> getNivelesUser(Usuario u) throws AppDataException{
		ArrayList<Nivel> niveles = new ArrayList <Nivel>();
		Nivel n=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select * from nivel_usuario nu inner join nivel n on nu.idnivel=n.idnivel where nu.idUsuario=?");
			stmt.setInt(1, u.getIdU());			
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					n = new Nivel();
					n.setIdNivel(rs.getInt("nu.idnivel"));
					//System.out.println(n.getIdNivel());
					n.setDescripcion(rs.getString("n.descripcion"));	
					//System.out.println(n.getDescripcion());
					niveles.add(n);
					}		
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
	
	public ArrayList<Usuario> getAll() throws Exception{	
		Statement stmt=null;
		ResultSet rs=null;
		Usuario u=null;
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from usuario");
			if(rs!=null){
				while(rs.next()){
					u = new Usuario();
					u.setNombre(rs.getString("nombre"));
					u.setUser(rs.getString("user"));
					u.setApellido(rs.getString("apellido"));
					u.setCorreo(rs.getString("correo"));
					u.setFecAlta(rs.getString("fecalta"));
					u.setFecEstado(rs.getString("fecestado"));
					u.setEstado(rs.getString("estado"));
					u.setIdU(rs.getInt("idU"));
					u.setNotas(rs.getString("notas"));
					u.setNivel(this.getNivelesUser(u));
					usuarios.add(u);
				}
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar Usuarios de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return usuarios;
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
				uLog.setNotas(rs.getString("notas"));
				uLog.setNivel(this.getNivelesUser(uLog));
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

	public Usuario getById(Usuario u) throws AppDataException {
		Usuario usu = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from usuario where idU=?");
			stmt.setInt(1, u.getIdU());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				usu = new Usuario();
				usu.setNombre(rs.getString("nombre"));
				usu.setUser(rs.getString("user"));
				usu.setApellido(rs.getString("apellido"));
				usu.setCorreo(rs.getString("correo"));
				usu.setFecAlta(rs.getString("fecalta"));
				usu.setFecEstado(rs.getString("fecestado"));
				usu.setEstado(rs.getString("estado"));
				usu.setIdU(rs.getInt("idU"));
				usu.setNotas(rs.getString("notas"));
				usu.setPass(rs.getString("pass"));
				usu.setNivel(this.getNivelesUser(usu));
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
		return usu;
	}


	public void deleteNivUser(Usuario u) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"delete from nivel_usuario where idUsuario=?");	
			stmt.setInt(1, u.getIdU());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible borrar Niveles de Usuario en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 		
	}

	public void insertNivUser(Usuario u) throws AppDataException {
		
		for(int i=0;i<u.getNivel().size();i++){	
			PreparedStatement stmt=null;
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
							"insert into nivel_usuario (idNivel, idUsuario) values (?,?)");	
				stmt.setInt(1, u.getNivel().get(i).getIdNivel());
				stmt.setInt(2,u.getIdU());
				stmt.executeUpdate();
			}catch (SQLException | AppDataException e) {
				throw new AppDataException(e,"No es posible agregar Niveles de Usuario a la BD");
				
			}finally{
				try{
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 		
		}
	}	
	
	public boolean existeUser(Usuario u) throws AppDataException {
		boolean b = false;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from usuario where user=?");
			stmt.setString(1, u.getUser());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				b= true;
				System.out.println("existe");
				System.out.println(rs.getString("user"));
				}			
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible validar existencia de usuario en la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
		return b;
	} 
} 