package application.models;

import java.sql.Connection;
import java.sql.SQLException;
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
	private String telefon;
	private String email;
	private String estatcivil;
	private String ocupacio;
	private String rol;
	private String timestamp;
	private Boolean activo;
	
	private Connection conexiondb;
	

	/*CONSTRUCTORES*/
	
	public Usuari() {
		this.conexiondb = Conexion.getConexion().conectar();
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
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
	
	public void insert(String nom_usuari, String contrasenya, String nom, String cognom1, String cognom2, String DNI, String passaport, String nacionalitat, String telefon, String email) {
		try {
			Statement s = this.conexiondb.createStatement();
			s.executeUpdate("INSERT INTO Usuaris (nom_usuari, contrasenya, nom, cognom1, cognom2, DNI, passaport, nacionalitat, telefon, email, rol) VALUES('"+nom_usuari+"','"+ contrasenya+"','" +nom+"','" +cognom1+"','" +cognom2+"','"+ DNI+"','"+ passaport+"','"+ nacionalitat+"','" +telefon+"','"+ email+"', 'rep')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(Integer id_usuari, String nom_usuari, String nom, String cognom1, String cognom2, String DNI, String passaport, String nacionalitat, String telefon, String email, Boolean actiu) {
		try {
			Statement s =  this.conexiondb.createStatement();
			s.executeUpdate("UPDATE Usuaris SET nom_usuari = '"+nom_usuari+"', nom = '"+nom+"', cognom1 = '"+cognom1+"', cognom2 = '"+cognom2+"', DNI = '"+DNI+"', passaport = '"+passaport+"', nacionalitat = '"+nacionalitat+"', telefon = '"+telefon+"', email = '"+email+"', activo = "+actiu+" WHERE id_usuari ="+id_usuari);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Boolean getActivo() {
		return this.activo;	
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;	
	}
	
}
