package application.models;

import java.sql.Connection;
import java.sql.Statement;

public class Habitacio {
	/*ATRIBUTOS*/
	
	private int id_habitacio;
	private int planta;
	private int preu;
	private String estat;
	private String tipus;
	private String descripcio;
	private String caracteristiques;
	
	/*CONSTRUCTORES*/
	
	public Habitacio() {
		
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

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
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
}
