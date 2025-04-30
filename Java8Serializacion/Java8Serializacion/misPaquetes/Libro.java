package misPaquetes;

import java.io.*;

public class Libro implements Serializable{
	String Libro;
	String Autor;
	String ISBN;
	int AnoPublicacion;
	
	public Libro(String Libro, String Autor, String ISBN, int AnoPublicacion) {
		this.Libro = Libro;
		this.Autor = Autor;
		this.ISBN = ISBN;
		this.AnoPublicacion = AnoPublicacion;
		
	}
	
	 public String toString() {
	        return "Título: " + Libro + ", Autor: " + Autor + ", ISBN: " + ISBN + ", Año: " + AnoPublicacion;
	    }
}




