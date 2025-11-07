package T06.T6;

// Testa a soma das áreas
public class TestaSomaAreas {

    public static void main(String[] args) {

        // Vetor polimórfico
        Superficie[] formas = new Superficie[3];

        // Instâncias
        formas[0] = new Retangulo(10.0, 5.0);     // 50.00
        formas[1] = new Triangulo(10.0, 5.0);     // 25.00
        formas[2] = new Circunferencia(5.0);      // 78.54 aprox.

        // Soma total
        double total = CalculadorDeArea.somarAreas(formas);

        // Saída
        System.out.println("--- Soma das Áreas ---");
        System.out.printf("Área do Retângulo: %.2f%n", formas[0].area());
        System.out.printf("Área do Triângulo: %.2f%n", formas[1].area());
        System.out.printf("Área da Circunferência: %.2f%n", formas[2].area());
        System.out.println("-------------------------");
        System.out.printf("SOMA TOTAL: %.2f%n", total);
    }
}

