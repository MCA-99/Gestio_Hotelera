package application.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;


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
		userLoged = new Usuari();
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
	
	public void insertRecepcionista(String nom_usuari, String contrasenya, String nom, String cognom1, String cognom2, String DNI, String passaport, String nacionalitat, String telefon, String email) {
		try {
			Statement s = this.conexiondb.createStatement();
			s.executeUpdate("INSERT INTO Usuaris (nom_usuari, contrasenya, nom, cognom1, cognom2, DNI, passaport, nacionalitat, telefon, email, rol) VALUES('"+nom_usuari+"','"+ contrasenya+"','" +nom+"','" +cognom1+"','" +cognom2+"','"+ DNI+"','"+ passaport+"','"+ nacionalitat+"','" +telefon+"','"+ email+"', 'rep')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMD5(String contrasenya) {
		String resultado = "";
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(contrasenya.getBytes("UTF-8"));
			byte[] rs = md5.digest();
			resultado = DatatypeConverter.printHexBinary(rs).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
}
