package misPaquetes;

public interface Volador {
	void volar();
}

class Avion implements Volador {
	public void volar() {
		System.out.println("El avion vuela a muchos metros de altura");
	}
}

class Pajaro implements Volador {
	public void volar() {
		System.out.println("El pajaro vuela a menons metro que el avion");
	}
}