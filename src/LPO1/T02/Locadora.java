package LPO1.T02;

import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a quantidade de DVDs que a locadora possui: ");
        int quantDvds = sc.nextInt();

        System.out.println("Informe o valor de alguguel de cada DVD: ");
        double valorAluguel = sc.nextDouble();

        int quantAlugada = (int) ((1.0/ 3.0) * quantDvds);

        double faturamentoAnual = (quantAlugada * valorAluguel) * 12;

        double valorMulta = 0.1*valorAluguel;
        int quantDvdsMultados = (int) (0.1 * quantAlugada);

        double ganhosMultaMes = valorMulta*quantDvdsMultados;

        System.out.printf("O faturamento anual é R$ %.2f\n", faturamentoAnual);
        System.out.printf("O valor ganho com multas por mês é R$ %.2f ",  ganhosMultaMes);

        sc.close();

    }
}
