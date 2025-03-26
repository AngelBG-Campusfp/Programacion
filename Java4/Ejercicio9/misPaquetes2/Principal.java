package misPaquetes2;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura figura1 = new Circulo(5);
		System.out.println("El área del círculo es: " + figura1.calcularArea());
		
		 Figura figura2 = new Rectangulo(4, 7); 
		 System.out.println("El área del rectángulo es: " + figura2.calcularArea());
		 
	}

}
