package misPaquetes;

public class Electrodomestico {
	String marca;
	int precio;
	
}

class Lavadora extends Electrodomestico {
	int capacidadKg;
	
	public void mostrarDatos(String marca, int precio, int capacidadKg) {
		this.marca = marca;
		this.precio = precio;
		this.capacidadKg = capacidadKg;
	}
	
}

class Televisor extends Electrodomestico {
	int pulgadas;
	
	public void mostrarDatos(String marca, int precio, int pulgadas) {
		this.marca = marca;
		this.precio = precio;
		this.pulgadas = pulgadas;
	}
}
