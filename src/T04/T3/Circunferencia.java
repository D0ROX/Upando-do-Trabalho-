package T04.T3;

public class Circunferencia {

    private double raio;

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return this.raio;
    }

    public double calculaArea() {
        // Fórmula da área: PI * raio^2
        return Math.PI * this.raio * this.raio;
    }
}
