package application.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	/*ATRIBUTOS*/
	private Conexion conexion;
	private Connection conexiondb;
	private static Database database; 
	/*CONSTRUCTOR*/
	
	private Database(){
		this.conexion = Conexion.getConexion();
		this.conexiondb = conexion.conectar();
	}
	
	/*METODOS*/
	
	public static Database getDatabase() {
		Database db = Database.database;
		if(db == null) {
			Database.database = new Database();
			db = Database.database;
		}
		return db;
	}
	
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
		
	}
	
}
