package LPO1.T06.T4;

// Implementa Superficie
public class Circunferencia implements Superficie {

    private double raio;

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    // Área = π * r^2
    @Override
    public double area() {
        return Math.PI * raio * raio;
    }
}

