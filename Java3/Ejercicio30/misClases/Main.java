public class Main {
    public static void main(String[] args) {
        Verificador verificador = new Verificador();

        System.out.println(verificador.esPositivoYPar(4));  
        System.out.println(verificador.esPositivoYPar(-2)); 
        System.out.println(verificador.esPositivoYPar(3));  
        System.out.println(verificador.esPositivoYPar(0));  
    }
}