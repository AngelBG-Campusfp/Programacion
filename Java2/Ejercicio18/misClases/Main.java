public class Main {
    public static void main(String[] args) {
        Conversor conver = new Conversor();
        
        double decimal = 14.33;
        int entero = conver.convertirDoubleAInt(decimal);
        
        System.out.println("El numero " + decimal + "convertido a entero es: " 	+ entero);
    }
}