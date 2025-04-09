package misPaquetes;

//Creo la clase Gato que hereda de Animal
public class Gato extends Animal {
	boolean test_leucemia;
	
	//Metodo constructor
	public Gato (int numero_de_chip, String nombre, int edad, String raza, boolean adoptado, boolean test_leucemia) {
		super(numero_de_chip, nombre, edad, raza, adoptado);
		this.test_leucemia = test_leucemia;
	}
	
	//Metodo mostrar
	public void mostrar() {
		System.out.println("Numero Chip:" + numero_de_chip);
		System.out.println("Nombre" + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Raza: " + raza);
		System.out.println("Adoptado: " + adoptado );
		System.out.println("Leucemia: " + test_leucemia);
	}

}
