package misPaquetes;

//Creo la clase abstracta animal con sus atributos
public abstract class Animal {
	int numero_de_chip;
	String nombre;
	int edad;
	String raza;
	boolean adoptado;
	
	//Metodo constructor
	public Animal(int numero_de_chip, String nombre, int edad, String raza, boolean adoptado) {
		this.numero_de_chip = numero_de_chip;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.adoptado = adoptado;
	}
	
	public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }
	
	//Metodo mostrar
	public abstract void mostrar();
}

//Creo la clase perro que hereda de animal
class Perro extends Animal {
	boolean tamaño;
	
	//Metodo constructor
	public Perro (int numero_de_chip, String nombre, int edad, String raza, boolean adoptado, boolean tamaño) {
		super(numero_de_chip, nombre, edad, raza, adoptado);
		this.tamaño = tamaño;
	}
	
	//Metodo mostrar
	public void mostrar() {
		System.out.println("Numero Chip:" + numero_de_chip);
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Raza: " + raza);
		System.out.println("Adoptado: " + adoptado );
		System.out.println("Tamaño: " + tamaño);
	}
}
