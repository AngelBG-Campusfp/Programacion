package misPaquetes;

public interface Logger {
	void registrar(String mensaje);
	
	default void separador() {
		System.out.println("------------------------");
	}
}

class ConsolaLogger implements Logger {
	public void registrar(String mensaje) {
		System.out.println("Mensaje: " + mensaje);
	}
}