package T02;

import java.util.Scanner;

public class DoisPontos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1, y1, x2, y2;

        System.out.print("Digite a coordenada x: ");
        x1 = sc.nextDouble();
        System.out.print("Digite a coordenada y: ");
        y1 = sc.nextDouble();

        System.out.print("Digite a coordenada x: ");
        x2 = sc.nextDouble();
        System.out.print("Digite a coordenada y: ");
        y2 = sc.nextDouble();

        double distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        System.out.printf("\nA distância entre os dois pontos é: %.2f\n", distancia);

        sc.close();
    }
}
