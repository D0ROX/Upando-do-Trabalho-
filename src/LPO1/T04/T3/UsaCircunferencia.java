package LPO1.T04.T3;

public class UsaCircunferencia {

    public static void main(String[] args) {

        Circunferencia c1 = new Circunferencia();
        c1.setRaio(10.0);

        System.out.println("Teste 1: ");
        System.out.printf("Raio: %.2f\n", c1.getRaio());
        System.out.printf("Área: %.2f\n", c1.calculaArea());

        Circunferencia c2 = new Circunferencia();
        c2.setRaio(5.5);

        System.out.println("\nTeste 2: ");
        System.out.printf("Raio: %.2f\n", c2.getRaio());
        System.out.printf("Área: %.2f\n", c2.calculaArea());
    }
}
