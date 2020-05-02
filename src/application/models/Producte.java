package application.models;

import java.sql.Connection;
import java.sql.Statement;

public class Producte {
	/*ATRIBUTOS*/
	
	private int id_servei;
	private String nom;
	private int preu;
	
	/*CONSTRUCTORES*/
	
	public Producte() {
		
	}

	/*METODOS*/

	public int getId_servei() {
		return id_servei;
	}

	public void setId_servei(int id_servei) {
		this.id_servei = id_servei;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}
}
