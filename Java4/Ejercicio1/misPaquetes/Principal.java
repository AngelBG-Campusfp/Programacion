package misPaquetes;

public class Principal {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Isi Palazon";
        persona1.edad = 19;
        persona1.mostrarInfo();
        
        Persona persona2 = new Persona();
        persona2.nombre = "Angel";
        persona2.edad = 18;
        persona2.mostrarInfo();
    }
}