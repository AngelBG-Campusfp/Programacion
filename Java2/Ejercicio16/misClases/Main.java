public class Main {
    public static void main(String[] args) {
        Verificador verifica = new Verificador();  
        
	int numero = 5;
	boolean resultado = verifica.esMayorYPar(numero);
	
	if (resultado) {
            System.out.println(numero + " es mayor que 10 y par.");
        } else {
            System.out.println(numero + " no cumple con ambas condiciones.");
        }
    }
}