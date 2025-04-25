package misPaquetes;

import java.io.*;

public class Animal implements Serializable{
	String nombre;
	String especie;
	
	public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }
	
	public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
}
