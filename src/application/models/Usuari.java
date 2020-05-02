package application.models;

import java.sql.Connection;
import java.sql.Statement;

public class Usuari {
	/*ATRIBUTOS*/
	private int id_usuari;
	private String nom_usuari;
	private String contrasenya;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String DNI;
	private String passaport;
	private String nacionalitat;
	private int telefon;
	private String email;
	private String estatcivil;
	private String ocupacio;
	private String rol;
	private String timestamp;
	
	private Database db;
	private Boolean activo;

	/*CONSTRUCTORES*/
	
	public Usuari() {
		this.db = Database.getDatabase();
	}
	
	/*METODOS*/

	public int getId_usuari() {
		return id_usuari;
	}

	public void setId_usuari(int id_usuari) {
		this.id_usuari = id_usuari;
	}

	public String getNom_usuari() {
		return nom_usuari;
	}

	public void setNom_usuari(String nom_usuari) {
		this.nom_usuari = nom_usuari;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getPassaport() {
		return passaport;
	}

	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}

	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstatcivil() {
		return estatcivil;
	}

	public void setEstatcivil(String estatcivil) {
		this.estatcivil = estatcivil;
	}

	public String getOcupacio() {
		return ocupacio;
	}

	public void setOcupacio(String ocupacio) {
		this.ocupacio = ocupacio;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void insertRecepcionista(String nom_usuari, String contrasenya, String nom, String cognom1, String cognom2, String DNI, String passaport, String nacionalitat, String telefon, String email) {
		db.insertRecepcionista(nom_usuari, contrasenya, nom, cognom1, cognom2, DNI, passaport, nacionalitat, telefon, email);
		
	}
	
	public void insertCliente() {
		
	}
	
	public Boolean getActivo() {
		return this.activo;	
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;	
	}
	
}
