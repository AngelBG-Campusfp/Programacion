package misPaquetes;

public class Vehiculo {
	String marca;
	String modelo;
	
	
}

class Coche extends Vehiculo {
	int puertas;
	
	public Coche(String marca, String modelo, int puertas) {
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
	}
	
	public void mostrarDatos() {
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Nº de Puertas: " + puertas);
	}
}