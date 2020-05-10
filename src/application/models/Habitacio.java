package application.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Habitacio {
	/*ATRIBUTOS*/
	
	private int id_habitacio;
	private int planta;
	private Float preu;
	private String estat;
	private String tipus;
	private String descripcio;
	private String caracteristiques;
	
	private Connection conexiondb;
	
	/*CONSTRUCTORES*/
	
	public Habitacio() {
		this.conexiondb = Conexion.getConexion().conectar();
	}

	/*METODOS*/
	
	public int getId_habitacio() {
		return id_habitacio;
	}

	public void setId_habitacio(int id_habitacio) {
		this.id_habitacio = id_habitacio;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	public void update(Integer id_habitacio, Integer planta, Float preu, String estat, String tipus, String descripcio, String caracteristiques) {
		try {
			Statement s = this.conexiondb.createStatement();
			s.executeUpdate("UPDATE Habitacions SET planta = '"+planta+"', preu = '"+preu+"', estat = '"+estat+"', tipus = '"+tipus+"', descripcio = '"+descripcio+"', caracteristiques = '"+caracteristiques+"' WHERE id_habitacio ="+id_habitacio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Integer planta, Float preu, String estat, String tipus, String descripcio, String caracteristiques) {
		try {
			Statement s = this.conexiondb.createStatement();
			s.executeUpdate("INSERT INTO Habitacions (planta, preu, estat, tipus, descripcio, caracteristiques) VALUES('"+planta+"','"+ preu+"','" +estat+"','" +tipus+"','" +descripcio+"','"+ caracteristiques+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
