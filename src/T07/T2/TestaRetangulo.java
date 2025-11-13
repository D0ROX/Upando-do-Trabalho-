package T07.T2;

// Testa criação de Retangulo e captura de argumentos inválidos (unchecked)
public class TestaRetangulo {

    public static void main(String[] args) {

        // Caso válido (não exige try/catch para unchecked, mas é útil em testes)
        System.out.println("Testando Retângulo 1 (Válido)");
        try {
            Retangulo r1 = new Retangulo(10.0, 5.0);
            System.out.println("Retângulo 1 criado com sucesso.");
            System.out.printf("Área R1: %.2f%n", r1.area());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro não esperado ao criar R1: " + e.getMessage());
        }

        // Caso inválido: lado negativo deve disparar IllegalArgumentException
        System.out.println("\nTestando Retângulo 2 (Inválido)");
        try {
            Retangulo r2 = new Retangulo(10.0, -5.0);
            System.out.println("ERRO NO TESTE: R2 foi criado, mas não deveria.");
            System.out.printf("Área R2: %.2f%n", r2.area());
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada (como esperado):");
            System.out.println(e.getMessage());
        }
    }
}

