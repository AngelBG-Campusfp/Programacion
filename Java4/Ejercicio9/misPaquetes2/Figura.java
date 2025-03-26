package misPaquetes2;

public abstract class Figura {
	public abstract double calcularArea();
}

class Circulo extends Figura {
    double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio; 
    }
}

class Rectangulo extends Figura {
    double base;
    double altura;
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura; 
    }
}