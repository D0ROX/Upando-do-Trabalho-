package LPO1.T06.T4;

// Implementa Superficie
public class Quadrado implements Superficie {

    private double lado;

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    // Área = lado^2
    @Override
    public double area() {
        return lado * lado;
    }
}

