package data;
import java.sql.*;
import util.AppDataException;


public class FactoryConexion {
	
	private String driver="com.mysql.jdbc.Driver";
	
	private String host="jdbc:mysql://mysql14861-soptica.jelastic.saveincloud.net:3306/dboptica";

	private String user="bdoptica";
	private String password="java";



	
	private static FactoryConexion instancia;
		
	private FactoryConexion(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static FactoryConexion getInstancia(){
		if (FactoryConexion.instancia == null){		
			FactoryConexion.instancia=new FactoryConexion();
		}
		return FactoryConexion.instancia;
		
	}
	
	private Connection conn;
	private int cantConn=0;
	public Connection getConn() throws SQLException,AppDataException{
		
			try {
				if(conn==null || conn.isClosed()){	
					System.out.println("BD");
					conn = DriverManager.getConnection(host, user, password);
					
				}
			}catch (SQLException ex){
			ex.printStackTrace();
			}
		
		cantConn++;
		return conn;
	}
	
	public void releaseConn() throws SQLException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	

}
