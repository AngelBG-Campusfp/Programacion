package misPaquetes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaBancaria cuenta = new CuentaBancaria();
		
		cuenta.depositar(1000);
		
		cuenta.retirar(500);
		
		System.out.println("Slado Final: " + cuenta.getSaldo());
;	}

}
