package T02;

import java.util.Scanner;

public class DistanciaPercorrida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float distanciaPercorrida = 0;
        float tempoGasto = 0;
        float velocidadeMedia = 0;

        System.out.println("Digite a distancia percorrida (em km): ");
        distanciaPercorrida = sc.nextFloat();

        System.out.println("Digite o tempo gasto na viagem (em horas): ");
        tempoGasto = sc.nextFloat();

        velocidadeMedia =  (distanciaPercorrida/tempoGasto);

        System.out.printf("A velocidade media dessa viagem foi %.2f: km/h \n ", velocidadeMedia);

        sc.close();

    }
}
