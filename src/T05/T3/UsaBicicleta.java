package T05.T3;

public class UsaBicicleta {
    public static void main(String[] args) {

        System.out.println("Bicicleta 1 (Padrão 18 marchas)");
        Bicicleta b1 = new Bicicleta();
        b1.printStates();

        System.out.println("Tentando mudar para marcha 20...");
        b1.mudarMarcha(20); // Deve falhar (max 18)

        System.out.println("\nBicicleta 2 (Custom 21 marchas)");
        Bicicleta b2 = new Bicicleta(21);
        b2.printStates();

        System.out.println("Tentando mudar para marcha 20...");
        b2.mudarMarcha(20); // Deve funcionar (max 21)
    }
}
