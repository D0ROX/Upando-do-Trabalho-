package T07.T1;

// Testes de exceções verificadas e manutenção de estado
public class UsaBicicleta {

    public static void main(String[] args) {
        Bicicleta bike = new Bicicleta();
        System.out.println("Bicicleta criada. Estado inicial:");
        bike.printStates();
        System.out.println("-------------------------------------");

        // Velocidade válida
        try {
            System.out.println("Tentando setar velocidade para 50...");
            bike.setVelocidade(50);
            bike.printStates();
        } catch (VelocidadeException e) {
            System.out.println(e.getMessage());
        }

        // Velocidade fora da faixa (gera exceção)
        try {
            System.out.println("\nTentando setar velocidade para 110...");
            bike.setVelocidade(110);
            bike.printStates();
        } catch (VelocidadeException e) {
            System.out.println("Falha capturada: " + e.getMessage());
        }

        // Marcha fora da faixa
        try {
            System.out.println("\nTentando setar marcha para 25...");
            bike.setMarcha(25);
            bike.printStates();
        } catch (MarchaException e) {
            System.out.println("Falha capturada: " + e.getMessage());
        }

        // Cadência negativa
        try {
            System.out.println("\nTentando setar cadência para -5...");
            bike.setCadencia(-5);
            bike.printStates();
        } catch (RPMException e) {
            System.out.println("Falha capturada: " + e.getMessage());
        }

        System.out.println("\n-------------------------------------");
        System.out.println("Estado final da bicicleta (erros não alteram estado):");
        bike.printStates();
    }
}
