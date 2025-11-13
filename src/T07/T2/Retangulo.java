package T07.T2;

// Valida argumentos no construtor; usa exceção não monitorada (IllegalArgumentException)
public class Retangulo {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        if (base < 0 || altura < 0) {
            throw new IllegalArgumentException("Os lados do retângulo não podem ser negativos.");
        }
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }
}
