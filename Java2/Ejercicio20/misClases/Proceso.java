public class Proceso {

    public void pasoUno() {
        System.out.println("Iniciando proceso...");
    }

    public void pasoDos() {
        pasoUno();  // Llamada al método pasoUno()
        System.out.println("Proceso completado.");
    }
}