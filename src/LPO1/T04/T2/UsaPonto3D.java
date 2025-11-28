package LPO1.T04.T2;

public class UsaPonto3D {

    public static void main(String args[]) {

        Ponto3D p1 = new Ponto3D();
        p1.setX(1.0);
        p1.setY(2.0);
        p1.setZ(3.0);
        p1.setCor("Azul");

        Ponto3D p2 = new Ponto3D();
        p2.setX(4.0);
        p2.setY(6.0);
        p2.setZ(3.0);
        p2.setCor("Vermelho");

        double distancia = p1.calculaDistancia(p2);

        System.out.println("Teste de Distância: ");
        System.out.printf("A distância entre p1 e p2 é: %.2f\n", distancia);

        // Teste 2: Calcula a distância de p2 para p1 (deve dar o mesmo resultado)
        double distanciaInversa = p2.calculaDistancia(p1);
        System.out.printf("A distância entre p2 e p1 é: %.2f\n", distanciaInversa);
    }
}
