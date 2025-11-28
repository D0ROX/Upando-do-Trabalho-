package LPO1.T06.T6;

// Implementa Superficie
public class Retangulo implements Superficie {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Área = base * altura
    @Override
    public double area() {
        return base * altura;
    }
}

