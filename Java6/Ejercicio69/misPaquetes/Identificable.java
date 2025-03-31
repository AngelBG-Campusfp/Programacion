package misPaquetes;

public interface Identificable {
	void mostrarIdentidad();
}

class Empleado implements Identificable {
	String nombre;
	int id;
	
	public Empleado(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public void mostrarIdentidad() {
		System.out.println("ID:" + id);
		System.out.println("Nombre:" + nombre);
	}
}