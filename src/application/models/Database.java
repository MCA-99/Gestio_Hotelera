package application.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.DatatypeConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;


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
	
	public Usuari getUserLoged() {
		return userLoged;
	}
	
	public void clearUser() {
		userLoged = null;
	}
	
	public ObservableList<Usuari> getUsuaris(String filtro){
		ObservableList<Usuari> usuaris = FXCollections.observableArrayList();
		
		if(filtro != null) {
			try {
				Statement query = this.conexiondb.createStatement();
				ResultSet rs = query.executeQuery("SELECT * FROM Usuaris WHERE (rol LIKE 'rep') AND (id_usuari LIKE '"+filtro+"' OR nom_usuari LIKE '%"+filtro+"%' OR nom LIKE '%"+filtro+"%' OR cognom1 LIKE '%"+filtro+"%' OR cognom2 LIKE '%"+filtro+"%' OR DNI LIKE '%"+filtro+"%' OR passaport LIKE '%"+filtro+"%' OR nacionalitat LIKE '%"+filtro+"%' OR telefon LIKE '%"+filtro+"%' OR email LIKE '%"+filtro+"%' OR activo LIKE '%"+filtro+"%')");
				while(rs.next()) {
					Usuari u = new Usuari();
					u.setId_usuari(rs.getInt("id_usuari"));
					u.setNom_usuari(rs.getString("nom_usuari"));
					u.setContrasenya(rs.getString("contrasenya"));
					u.setNom(rs.getString("nom"));
					u.setCognom1(rs.getString("cognom1"));
					u.setCognom2(rs.getString("cognom2"));
					u.setDNI(rs.getString("DNI"));
					u.setPassaport(rs.getString("passaport"));
					u.setNacionalitat(rs.getString("nacionalitat"));
					u.setTelefon(rs.getInt("telefon"));
					u.setEmail(rs.getString("email"));
					u.setActivo(rs.getBoolean("activo"));
					
					usuaris.add(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return usuaris;
		
	}
	
	public ObservableList<Usuari> getUsuaris(){
		ObservableList<Usuari> usuaris = FXCollections.observableArrayList();
		
		try {
			Statement query = this.conexiondb.createStatement();
			ResultSet rs = query.executeQuery("SELECT * FROM Usuaris WHERE rol LIKE 'rep'");
			while(rs.next()) {
				Usuari u = new Usuari();
				u.setId_usuari(rs.getInt("id_usuari"));
				u.setNom_usuari(rs.getString("nom_usuari"));
				u.setContrasenya(rs.getString("contrasenya"));
				u.setNom(rs.getString("nom"));
				u.setCognom1(rs.getString("cognom1"));
				u.setCognom2(rs.getString("cognom2"));
				u.setDNI(rs.getString("DNI"));
				u.setPassaport(rs.getString("passaport"));
				u.setNacionalitat(rs.getString("nacionalitat"));
				u.setTelefon(rs.getInt("telefon"));
				u.setEmail(rs.getString("email"));
				u.setActivo(rs.getBoolean("activo"));
				
				usuaris.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuaris;

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
				userLoged.setTelefon(rs.getInt("telefon"));
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
	
	public boolean comprovarExistencia(String camp, String nomcamp, String nomTabla) {
		 boolean resultat = false;
		 ResultSet rs = null;
		try {
			Statement s = this.conexiondb.createStatement();
			rs = s.executeQuery("SELECT * FROM "+nomTabla+" WHERE "+nomcamp+" LIKE '"+camp+"'");
			if(rs.next() == true) {
				resultat = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultat;
	}
	
}
