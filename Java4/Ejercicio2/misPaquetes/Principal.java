package misPaquetes;

public class Principal {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Angel");
        Persona persona3 = new Persona("Angel", 22);
        
        persona1.mostrarInfo();
        persona2.mostrarInfo();
        persona3.mostrarInfo();
        
    }
}
