package misPaquetes;

public interface Saludador {
	void saludar();
}

class Robot implements Saludador {
	public void saludar() {
		System.out.println("Hola soy un robot");
	}
}
