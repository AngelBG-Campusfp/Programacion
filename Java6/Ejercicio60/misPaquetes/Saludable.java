package misPaquetes;

public interface Saludable {
	void realizarChequeo();
}

class Persona implements Saludable {
	public void realizarChequeo() {
		System.out.println("Se está realizando un chequeo médico");
	}
}
