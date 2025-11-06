package T05.T2;

public class UsaPonto3D {
    public static void main(String args[]) {

        Ponto3D p1 = new Ponto3D();
        p1.setX(1.0);
        p1.setY(2.0);
        p1.setZ(3.0);

        Ponto3D p2 = new Ponto3D();
        p2.setX(4.0);
        p2.setY(6.0);
        p2.setZ(3.0);

        // Tenta chamar o método 'calculaDistancia'
        double distancia = p1.calculaDistancia(p2);

        System.out.printf("A distância é: %.2f\n", distancia);
    }
}
