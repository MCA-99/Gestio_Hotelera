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
	private static Usuari userLoged;
	/*CONSTRUCTOR*/
	
	private Database(){
		this.conexion = Conexion.getConexion();
		this.conexiondb = conexion.conectar();
		this.userLoged = new Usuari();
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
	
	public static Usuari getUserLoged() {
		return userLoged;
	}
	
	public void getUsers() {
		try {
			Statement s = this.conexiondb.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Usuaris");
			while (rs.next())
			{
			    System.out.println (rs.getString("nom_usuari"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public boolean logear(String usuari, String contrasenya) {
		boolean resultado = false;
		try {
			Statement s = this.conexiondb.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM Usuaris WHERE nom_usuari = '"+usuari+"' AND contrasenya = '"+contrasenya+"'");
			if(rs.next()) {
				resultado = true;
				userLoged.setId_usuari(rs.getInt("id_usuari"));
				userLoged.setNom_usuari(rs.getString("nom_usuari"));
				userLoged.setContrasenya(rs.getString("contrasenya"));
				userLoged.setNom(rs.getString("nom"));
				userLoged.setCognom1(rs.getString("cognom1"));
				userLoged.setCognom2(rs.getString("cognom2"));
				userLoged.setDNI(rs.getString("DNI"));
				userLoged.setPassaport(rs.getString("passaport"));
				userLoged.setNacionalitat(rs.getString("nacionalitat"));
				userLoged.setTelefon(rs.getString("telefon"));
				userLoged.setEmail(rs.getString("email"));
				userLoged.setEstatcivil(rs.getString("estatcivil"));
				userLoged.setOcupacio(rs.getString("ocupacio"));
				userLoged.setRol(rs.getString("rol"));
				userLoged.setTimestamp(rs.getString("timestamp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
}
