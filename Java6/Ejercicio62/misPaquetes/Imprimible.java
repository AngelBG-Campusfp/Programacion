package misPaquetes;

public interface Imprimible {
	void imprimir();
}

class Factura implements Imprimible {
	public void imprimir() {
		System.out.println("Luz: 60€");
		System.out.println("Agua: 40€");
		System.out.println("Gas: 50€");
		System.out.println("Calefaccion: 300€");
	}
}