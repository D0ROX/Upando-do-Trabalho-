package LPO1.T06.T6;

// Implementa Superficie
public class Circunferencia implements Superficie {

    private double raio;

    public Circunferencia(double raio) {
        this.raio = raio;
    }

    // Área = π * r^2
    @Override
    public double area() {
        return Math.PI * raio * raio;
    }
}

