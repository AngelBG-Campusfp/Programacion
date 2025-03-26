package misPaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lavadora lavadora1 = new Lavadora();
		lavadora1.mostrarDatos("Toshiba", 310, 225);
		
		Televisor televisor1 = new Televisor();
		televisor1.mostrarDatos("LG", 415, 55);
		
		System.out.println("Datos de la Lavadora:");
        System.out.println("Marca: " + lavadora1.marca);
        System.out.println("Precio: " + lavadora1.precio);
        System.out.println("Capacidad: " + lavadora1.capacidadKg + " kg");
        
        System.out.println("\nDatos del Televisor:");
        System.out.println("Marca: " + televisor1.marca);
        System.out.println("Precio: " + televisor1.precio);
        System.out.println("Pulgadas: " + televisor1.pulgadas);
	}

}
