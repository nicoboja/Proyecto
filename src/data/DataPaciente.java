package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Paciente;
import util.AppDataException;

public class DataPaciente {

	public void add(Paciente pac)  throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into paciente (nombre, apellido, nroDoc, celular, ciudad, correo, direccion, fecNac, "
						+ "nota, os, nroOs, telefono) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, pac.getNombre());	
			stmt.setString(2, pac.getApellido());
			stmt.setInt(3, pac.getNroDoc());
			stmt.setInt(4, pac.getCelular());
			stmt.setString(5, pac.getCiudad());
			stmt.setString(6, pac.getCorreo());
			stmt.setString(7, pac.getDireccion());
			stmt.setString(8, pac.getFecNac());
			stmt.setString(9, pac.getNota());
			stmt.setString(10, pac.getOs());
			stmt.setInt(11, pac.getNroOs());
			stmt.setInt(12, pac.getTelefono());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible agregar Paciente a la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 				
	}

	public void delete(Paciente pac)  throws AppDataException {
		// TODO Auto-generated method stub		
	}

	public void update(Paciente pac)  throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"update paciente set nombre=?, apellido=?, nroDoc=?, celular=?, ciudad=?, correo=?, direccion=?, fecNac=?, nota=?, os=?, nroOs=? where idPac=?;");
			stmt.setString(1, pac.getNombre());	
			stmt.setString(2, pac.getApellido());
			stmt.setInt(3, pac.getNroDoc());
			stmt.setInt(4, pac.getCelular());
			stmt.setString(5, pac.getCiudad());
			stmt.setString(6, pac.getCorreo());
			stmt.setString(7, pac.getDireccion());
			stmt.setString(8, pac.getFecNac());
			stmt.setString(9, pac.getNota());
			stmt.setString(10, pac.getOs());
			stmt.setInt(11, pac.getNroOs());
			stmt.setInt(12, pac.getIdPac());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar Paciente en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 				
	}

	public Paciente getById(Paciente pac) throws AppDataException {
		Paciente p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from paciente where idPac=?");
			stmt.setInt(1, pac.getIdPac());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p = new Paciente();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setNroDoc(rs.getInt("nroDoc"));
				p.setCelular(rs.getInt("celular"));
				p.setCiudad(rs.getString("ciudad"));
				p.setCorreo(rs.getString("correo"));
				p.setDireccion(rs.getString("direccion"));
				p.setFecNac(rs.getString("fecNac"));
				p.setNota(rs.getString("nota"));
				p.setOs(rs.getString("os"));
				p.setNroOs(rs.getInt("nroOs"));
				p.setIdPac(rs.getInt("idPac"));
				}			
		}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar Paciente de la BD");
				
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return p;
	}

	public ArrayList<Paciente> getAll() throws AppDataException {
		Paciente p=null;
		Statement stmt=null;
		ResultSet rs=null;		
		ArrayList<Paciente> pacientes= new ArrayList<Paciente>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from paciente");
			if(rs!=null){
				while(rs.next()){
					p = new Paciente();
					p.setIdPac(rs.getInt("idPac"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setNroDoc(rs.getInt("nroDoc"));
					p.setCorreo(rs.getString("correo"));
					p.setTelefono(rs.getInt("telefono"));
					p.setDireccion(rs.getString("direccion"));
					p.setNota(rs.getString("nota"));
					p.setOs(rs.getString("os"));
					p.setNroOs(rs.getInt("nroOs"));
					p.setFecNac(rs.getString("fecNac"));
					p.setCelular(rs.getInt("celular"));
					p.setCiudad(rs.getString("ciudad"));
					pacientes.add(p);
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
		return pacientes;
	}
	
}
