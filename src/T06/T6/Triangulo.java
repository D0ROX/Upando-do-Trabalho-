package T06.T6;

// Implementa Superficie
public class Triangulo implements Superficie {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Área = (base * altura) / 2
    @Override
    public double area() {
        return (base * altura) / 2.0;
    }
}

