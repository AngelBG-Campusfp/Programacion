package misPaquetes;

public interface Accion {
	void ejecutar();
}

class Boton implements Accion {
	public void ejecutar() {
		System.out.println("Boton presionado");
	}
}