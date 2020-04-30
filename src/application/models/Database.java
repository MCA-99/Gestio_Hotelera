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
		this.conexiondb = conexion.conectar();
	}
	
	/*METODOS*/
	
	public void getUsers() {
		try {
			Statement s = this.conexiondb.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Usuaris");
			while (rs.next())
			{
			    System.out.println (rs.getString("nom_usuari"));
			}
			conexiondb.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conexion.getPropiedades());
		
		
	}
}
