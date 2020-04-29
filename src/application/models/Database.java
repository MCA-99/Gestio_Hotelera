package application.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	/*ATRIBUTOS*/
	private Conexion conexion = Conexion.getConexion();
	private Connection conexiondb = null;
	/*CONSTRUCTOR*/
	
	public Database(){
		this.conexiondb = conexion.getConexionDB();
	}
	
	/*METODOS*/
	
	public void getUsers() {
		try {
			Statement s = this.conexiondb.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Usuaris");
			while (rs.next())
			{
			    System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getDate(3));
			}
			conexiondb.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
