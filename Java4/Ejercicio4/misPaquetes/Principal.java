package misPaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleado1 = new Empleado("Angel", 1500, "Informatica");
		
		System.out.println("Nombre" + empleado1.nombre);
		System.out.println("Departamento" + empleado1.departamento);
		
		empleado1.mostrarDatos();
	}

}

class Jefe extends Empleado {
	public Jefe(String nombre, double salario, String departamento) {
		super(nombre, salario, departamento);
	}
}