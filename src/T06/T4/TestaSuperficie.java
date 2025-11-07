package T06.T4;

public class TestaSuperficie {

    public static void main(String[] args) {

        // Objetos concretos
        Quadrado q1 = new Quadrado();
        q1.setLado(10.0); // área = 100

        Circunferencia c1 = new Circunferencia();
        c1.setRaio(5.0); // área ≈ 78.53

        // Polimorfismo via interface
        Superficie s1 = q1;
        Superficie s2 = c1;

        System.out.println("Teste com Referências Individuais: ");
        System.out.printf("Área (s1 - Quadrado): %.2f%n", s1.area());
        System.out.printf("Área (s2 - Circunferencia): %.2f%n", s2.area());

        // Array polimórfico
        Superficie[] lista = new Superficie[] { q1, c1 };

        System.out.println("\nTeste com Array (Polimorfismo): ");
        for (Superficie s : lista) {
            System.out.printf("Área: %.2f%n", s.area());
        }
    }
}

