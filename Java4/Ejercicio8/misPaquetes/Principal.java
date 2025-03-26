package misPaquetes;

public class Principal {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Coche("Ford", "Focus", 5);

        vehiculo.describir();

        Coche coche = (Coche) vehiculo;  
        coche.mostrarDatos();
    }
}

