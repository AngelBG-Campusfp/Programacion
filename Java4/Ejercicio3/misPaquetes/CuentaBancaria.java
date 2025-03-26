package misPaquetes;

public class CuentaBancaria {
	private double saldo;
	
	public void depositar(double cantidad) {
		if (cantidad > 0) {
			saldo += cantidad;
			System.out.println("El deposito ha sido realizado con exito!");
		} else {
			System.out.println("Cantidad no valida.");
		}
	}
	
	public void retirar(double cantidad) {
		if (cantidad > 0 && cantidad <= saldo) {
			saldo -= cantidad;
			System.out.println("Retirada realizada con exito!");
		} else {
			System.out.println("Retirada no valida.");
		}
	}
	
	public double getSaldo() {
		return saldo;
	}
}
