package misPaquetes;

public class Adopcion {
    String nombreAnimal;
    String nombreAdoptante;
    String dniAdoptante;

    public Adopcion(String nombreAnimal, String nombreAdoptante, String dniAdoptante) {
        this.nombreAnimal = nombreAnimal;
        this.nombreAdoptante = nombreAdoptante;
        this.dniAdoptante = dniAdoptante;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public String getDniAdoptante() {
        return dniAdoptante;
    }
}