package application.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	/*ATRIBUTOS*/
	private String ruta;
	private Properties propiedades;
	private static Conexion conexion ;
	
	/*CONSTRUCTORES*/
	
	private Conexion(){
		try {
			this.ruta = new File("config.properties").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	/*METODOS*/
	
	public static Conexion getConexion() {
		Conexion con = Conexion.conexion;
		if(con == null) {
			Conexion.conexion = new Conexion();
			con = Conexion.conexion;
		}
		return con;
	}
	
	public Connection conectar() {
		this.propiedades = new Properties();
		InputStream input = null;
		Connection conexion = null;
		
		try {
			input = new FileInputStream(new File(this.ruta));
			this.propiedades.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String hostaname = this.propiedades.getProperty("hostaname");
		String dbuser = this.propiedades.getProperty("dbuser");
		String dbpass = this.propiedades.getProperty("dbpass");
		String dbname = this.propiedades.getProperty("dbname");
		
		 try {
			conexion = DriverManager.getConnection("jdbc:mysql://"+hostaname+"/"+dbname,dbuser,dbpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conexion;
	}
	
}
