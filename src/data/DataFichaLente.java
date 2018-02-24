package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.FichaLente;
import entity.LenteMaterial;
import entity.LenteTipo;
import entity.Paciente;
import entity.Usuario;
import util.AppDataException;

public class DataFichaLente {


	public void add(FichaLente fl) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into fichalente (fecEntrada, armazon, modelo, color, codesf, codcil, coiesf,"
						+ " coicil, lodesf, lodcil, codgrados, coigrados, lodgrados, loigrados, costoArm, "
						+ "costoCrist, sena, idPac, optico, tallerista, tipo, material, estado, fecEstado, "
						+ "fecReceta, fecEstimadaS, notas) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, fl.getFecEntrada());	
			stmt.setString(2,fl.getArmazon());
			stmt.setString(3, fl.getModelo());
			stmt.setString(4, fl.getColor());
			stmt.setFloat(5, fl.getCodesf());
			stmt.setFloat(6, fl.getCodcil());
			stmt.setFloat(7, fl.getCoiesf());
			stmt.setFloat(8, fl.getCoicil());
			stmt.setFloat(9, fl.getLodesf());
			stmt.setFloat(10, fl.getLodcil());
			stmt.setInt(11, fl.getCodgrados());
			stmt.setInt(12, fl.getCoigrados());
			stmt.setInt(13, fl.getLodgrados());
			stmt.setInt(14, fl.getLoigrados());
			stmt.setFloat(15, fl.getCostoArm());
			stmt.setFloat(16, fl.getCostoCrist());
			stmt.setFloat(17, fl.getSena());
			stmt.setInt(18, fl.getPaciente().getIdPac());
			stmt.setInt(19, fl.getOptico().getIdU());
			stmt.setInt(20, fl.getTallerista().getIdU());
			stmt.setInt(21, fl.getTipo().getIdTipo());
			stmt.setInt(22, fl.getMaterial().getIdMaterial());
			stmt.setString(23, fl.getEstado());
			stmt.setString(24, fl.getFecEstado());
			stmt.setString(25, fl.getFecReceta());
			stmt.setString(26, fl.getFecEstimadaS());
			stmt.setString(27, fl.getNotas());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible agregar Nueva Ficha a la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		}	
	}

	public void delete(FichaLente fl) {
		// TODO Auto-generated method stub
		
	}

	public void update(FichaLente fl) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"update fichalente set fecEntrada=?, armazon=?, modelo=?, color=?, codesf=?, codcil=?, coiesf=?,"
						+ " coicil=?, lodesf=?, lodcil=?, codgrados=?, coigrados=?, lodgrados=?, loigrados=?, costoArm=?,"
						+ " costoCrist=?, sena=?, idPac=?, optico=?, tallerista=?, tipo=?, material=?, estado=?, fecEstado=?,"
						+ " fecReceta=?, fecEstimadaS=?, notas=? where idFicha=?");
			
			stmt.setString(1, fl.getFecEntrada());	
			stmt.setString(2,fl.getArmazon());
			stmt.setString(3, fl.getModelo());
			stmt.setString(4, fl.getColor());
			stmt.setFloat(5, fl.getCodesf());
			stmt.setFloat(6, fl.getCodcil());
			stmt.setFloat(7, fl.getCoiesf());
			stmt.setFloat(8, fl.getCoicil());
			stmt.setFloat(9, fl.getLodesf());
			stmt.setFloat(10, fl.getLodcil());
			stmt.setInt(11, fl.getCodgrados());
			stmt.setInt(12, fl.getCoigrados());
			stmt.setInt(13, fl.getLodgrados());
			stmt.setInt(14, fl.getLoigrados());
			stmt.setFloat(15, fl.getCostoArm());
			stmt.setFloat(16, fl.getCostoCrist());
			stmt.setFloat(17, fl.getSena());
			stmt.setInt(18, fl.getPaciente().getIdPac());
			stmt.setInt(19, fl.getOptico().getIdU());
			stmt.setInt(20, fl.getTallerista().getIdU());
			stmt.setInt(21, fl.getTipo().getIdTipo());
			stmt.setInt(22, fl.getMaterial().getIdMaterial());
			stmt.setString(23, fl.getEstado());			
			stmt.setString(24, fl.getFecEstado());
			stmt.setString(25, fl.getFecReceta());
			stmt.setString(26, fl.getFecEstimadaS());
			stmt.setString(27, fl.getNotas());
			stmt.setInt(28, fl.getIdFicha());
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar Ficha en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 				
		
	}

	public FichaLente getById(FichaLente fl) throws AppDataException {
		FichaLente fic=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		DataPaciente dataPac = new DataPaciente();
		DataUsuario dataUs = new DataUsuario();
		DataLenteTipo dataTipo = new DataLenteTipo();
		DataLenteMaterial dataMat = new DataLenteMaterial();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from fichalente where idFicha=?");
			stmt.setInt(1, fl.getIdFicha());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				fic = new FichaLente();
				fic.setMaterial(new LenteMaterial());
				fic.setTipo(new LenteTipo());
				fic.setPaciente(new Paciente());
				fic.setOptico(new Usuario());
				fic.setTallerista(new Usuario());
				fic.setIdFicha(rs.getInt("idFicha")); 
				fic.setFecEntrada(rs.getString("fecEntrada"));
				fic.setArmazon(rs.getString("armazon"));
				fic.setModelo(rs.getString("modelo"));
				fic.setColor(rs.getString("color"));
				fic.setCodesf(rs.getFloat("codesf"));
				fic.setCodcil(rs.getFloat("codcil"));
				fic.setCoiesf(rs.getFloat("coiesf"));
				fic.setCoicil(rs.getFloat("coicil"));
				fic.setLodesf(rs.getFloat("lodesf"));
				fic.setLodcil(rs.getFloat("lodcil"));
				fic.setCodgrados(rs.getInt("codgrados"));
				fic.setCoigrados(rs.getInt("coigrados"));
				fic.setLodgrados(rs.getInt("lodgrados"));
				fic.setLoigrados(rs.getInt("loigrados"));
				fic.setCostoArm(rs.getFloat("costoArm"));
				fic.setCostoCrist(rs.getFloat("costoCrist"));
				fic.setSena(rs.getFloat("sena"));
				fic.getPaciente().setIdPac(rs.getInt("idPac"));
				fic.setPaciente(dataPac.getById(fic.getPaciente()));
				fic.getOptico().setIdU(rs.getInt("optico"));
				fic.setOptico(dataUs.getById(fic.getOptico()));
				fic.getTallerista().setIdU(rs.getInt("tallerista"));
				fic.setTallerista(dataUs.getById(fic.getTallerista()));
				fic.getTipo().setIdTipo(rs.getInt("tipo"));
				fic.setTipo(dataTipo.getById(fic.getTipo()));
				fic.getMaterial().setIdMaterial(rs.getInt("material"));
				fic.setMaterial(dataMat.getById(fic.getMaterial()));
				fic.setEstado(rs.getString("estado"));
				fic.setFecEstado(rs.getString("fecEstado"));
				fic.setFecReceta(rs.getString("fecReceta"));
				fic.setFecEstimadaS(rs.getString("fecEstimadaS"));				
				fic.setNotas(rs.getString("notas"));
				}			
			}catch (SQLException e) {
				throw new AppDataException(e,"No es posible recuperar Ficha de la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
			return fic;
	}

	public ArrayList<FichaLente> getByEstado(String est) throws AppDataException {
		FichaLente fic=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		DataPaciente dataPac = new DataPaciente();
		DataUsuario dataUs = new DataUsuario();
		DataLenteTipo dataTipo = new DataLenteTipo();
		DataLenteMaterial dataMat = new DataLenteMaterial();
		ArrayList<FichaLente> fichas= new ArrayList<FichaLente>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from fichalente where estado=?");
			stmt.setString(1, est);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					fic = new FichaLente();
					fic.setMaterial(new LenteMaterial());
					fic.setTipo(new LenteTipo());
					fic.setPaciente(new Paciente());
					fic.setOptico(new Usuario());
					fic.setTallerista(new Usuario());
					fic.setIdFicha(rs.getInt("idFicha")); 
					fic.setFecEntrada(rs.getString("fecEntrada"));
					fic.setArmazon(rs.getString("armazon"));
					fic.setModelo(rs.getString("modelo"));
					fic.setColor(rs.getString("color"));
					fic.setCodesf(rs.getFloat("codesf"));
					fic.setCodcil(rs.getFloat("codcil"));
					fic.setCoiesf(rs.getFloat("coiesf"));
					fic.setCoicil(rs.getFloat("coicil"));
					fic.setLodesf(rs.getFloat("lodesf"));
					fic.setLodcil(rs.getFloat("lodcil"));
					fic.setCodgrados(rs.getInt("codgrados"));
					fic.setCoigrados(rs.getInt("coigrados"));
					fic.setLodgrados(rs.getInt("lodgrados"));
					fic.setLoigrados(rs.getInt("loigrados"));
					fic.setCostoArm(rs.getFloat("costoArm"));
					fic.setCostoCrist(rs.getFloat("costoCrist"));
					fic.setSena(rs.getFloat("sena"));					
					fic.getPaciente().setIdPac(rs.getInt("idPac"));
					fic.setPaciente(dataPac.getById(fic.getPaciente()));
					fic.getOptico().setIdU(rs.getInt("optico"));
					fic.setOptico(dataUs.getById(fic.getOptico()));
					fic.getTallerista().setIdU(rs.getInt("tallerista"));
					fic.setTallerista(dataUs.getById(fic.getTallerista()));
					fic.getTipo().setIdTipo(rs.getInt("tipo"));
					fic.setTipo(dataTipo.getById(fic.getTipo()));
					fic.getMaterial().setIdMaterial(rs.getInt("material"));
					fic.setMaterial(dataMat.getById(fic.getMaterial()));
					fic.setEstado(rs.getString("estado"));
					fic.setFecEstado(rs.getString("fecEstado"));
					fic.setFecReceta(rs.getString("fecReceta"));
					fic.setFecEstimadaS(rs.getString("fecEstimadaS"));				
					fic.setNotas(rs.getString("notas"));
					fichas.add(fic);
					}				
				}			
			}catch (SQLException| AppDataException e) {
				throw new AppDataException(e,"No es posible recuperar Ficha de la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
			return fichas;
	}
	
	public ArrayList<FichaLente> getByPaciente(Paciente p) throws AppDataException {
		FichaLente fic=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		DataPaciente dataPac = new DataPaciente();
		DataUsuario dataUs = new DataUsuario();
		DataLenteTipo dataTipo = new DataLenteTipo();
		DataLenteMaterial dataMat = new DataLenteMaterial();
		ArrayList<FichaLente> fichas= new ArrayList<FichaLente>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT * from fichalente where idPac=?");
			stmt.setInt(1, p.getIdPac());
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					fic = new FichaLente();
					fic.setMaterial(new LenteMaterial());
					fic.setTipo(new LenteTipo());
					fic.setPaciente(new Paciente());
					fic.setOptico(new Usuario());
					fic.setTallerista(new Usuario());
					fic.setIdFicha(rs.getInt("idFicha")); 
					fic.setFecEntrada(rs.getString("fecEntrada"));
					fic.setArmazon(rs.getString("armazon"));
					fic.setModelo(rs.getString("modelo"));
					fic.setColor(rs.getString("color"));
					fic.setCodesf(rs.getFloat("codesf"));
					fic.setCodcil(rs.getFloat("codcil"));
					fic.setCoiesf(rs.getFloat("coiesf"));
					fic.setCoicil(rs.getFloat("coicil"));
					fic.setLodesf(rs.getFloat("lodesf"));
					fic.setLodcil(rs.getFloat("lodcil"));
					fic.setCodgrados(rs.getInt("codgrados"));
					fic.setCoigrados(rs.getInt("coigrados"));
					fic.setLodgrados(rs.getInt("lodgrados"));
					fic.setLoigrados(rs.getInt("loigrados"));
					fic.setCostoArm(rs.getFloat("costoArm"));
					fic.setCostoCrist(rs.getFloat("costoCrist"));
					fic.setSena(rs.getFloat("sena"));					
					fic.getPaciente().setIdPac(rs.getInt("idPac"));
					fic.setPaciente(dataPac.getById(fic.getPaciente()));
					fic.getOptico().setIdU(rs.getInt("optico"));
					fic.setOptico(dataUs.getById(fic.getOptico()));
					fic.getTallerista().setIdU(rs.getInt("tallerista"));
					fic.setTallerista(dataUs.getById(fic.getTallerista()));
					fic.getTipo().setIdTipo(rs.getInt("tipo"));
					fic.setTipo(dataTipo.getById(fic.getTipo()));
					fic.getMaterial().setIdMaterial(rs.getInt("material"));
					fic.setMaterial(dataMat.getById(fic.getMaterial()));
					fic.setEstado(rs.getString("estado"));
					fic.setFecEstado(rs.getString("fecEstado"));
					fic.setFecReceta(rs.getString("fecReceta"));
					fic.setFecEstimadaS(rs.getString("fecEstimadaS"));				
					fic.setNotas(rs.getString("notas"));
					fichas.add(fic);
					}				
				}			
			}catch (SQLException| AppDataException e) {
				throw new AppDataException(e,"No es posible recuperar Ficha de la BD");
				
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				}catch (SQLException e) {
					e.printStackTrace();	
				}
			} 
			return fichas;
	}

	public int getCantEstado(String est) throws AppDataException {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int cant=0;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT count(*) as cant from fichalente where estado=?");
			stmt.setString(1, est);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				cant=rs.getInt("cant");
			}
		}catch (SQLException| AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar Estados de las Fichas de la BD");
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return cant;
	}

	public void cambiarEstado(FichaLente fl) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"update fichalente set estado=?, fecEstado=? where idFicha=?");
			
			stmt.setString(1, fl.getEstado());
			stmt.setString(2, fl.getFecEstado());
			stmt.setInt(3, fl.getIdFicha());			
			stmt.executeUpdate();
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar Ficha en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		}		
	}
}

