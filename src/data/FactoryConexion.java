package data;
import java.sql.*;
import util.AppDataException;


public class FactoryConexion {
	
	private String driver="com.mysql.jdbc.Driver";
	private String hostI="jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9224283";
	private String userI="sql9224283";
	private String passwordI="vZlfgVaENy";
	
	private String hostW="localhost";
	private String hostM="127.0.0.1";
	
	private String port="3306";
	private String user="root";
	private String password="root";
	private String db="bdoptica";
	


	
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
					conn = DriverManager.getConnection(
					        "jdbc:mysql://"+hostM+":"+port+"/"+db+"?user="+user+"&password="+password);
					
					
				}
			}catch (SQLException e){
				try {
					if(conn==null || conn.isClosed()){	
						conn = DriverManager.getConnection(
						        "jdbc:mysql://"+hostW+":"+port+"/"+db+"?user="+user+"&password="+password);
						
					}
				
				} catch (Exception ee) {
					try {
						if(conn==null || conn.isClosed()){	
							System.out.println("BD");
							conn = DriverManager.getConnection(hostI, userI, passwordI);
							
						}
					
					} catch (Exception eee) {
					// TODO: handle exception
					}
				}
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
