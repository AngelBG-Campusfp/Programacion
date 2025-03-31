package misPaquetes;

public interface Figura {
	void calcularArea();
}

class Cuadrado implements Figura {
	int lado;
	
	public Cuadrado(int lado) {
		this.lado = lado;
	}
	
	public void calcularArea() {
		System.out.println("Area Cuadrado: " + (lado * lado));
	}
}

class Triangulo implements Figura {
	int base;
	int altura;
	
	public Triangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public void calcularArea() {
		System.out.println("Area Triangulo: " + (base * altura));
	}
}