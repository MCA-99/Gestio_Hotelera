package application.models;

import java.io.File;
import java.util.Properties;

public class Conexion {
	/*ATRIBUTOS*/
	private String ruta = null;
	private Properties propiedades = null;
	private Conexion conexion = null;
	
	/*CONSTRUCTORES*/
	
	private Conexion(){
		this.ruta = new File('../config.properties');
	}
	
	/*METODOS*/
	
}
