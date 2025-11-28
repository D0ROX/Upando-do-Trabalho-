package LPO1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATV7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimensao = 0;

        while (true) {
            try {
                System.out.print("Informe a dimensão da matriz quadrada (ex: 3 para 3x3): ");
                dimensao = sc.nextInt();
                if (dimensao > 0) {
                    break;
                } else {
                    System.out.println("--> Erro: A dimensão deve ser um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("--> Erro: Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }
        }

        double[][] matriz = new double[dimensao][dimensao];

        preencherMatriz(matriz, sc);

        System.out.println("\nA matriz informada foi:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%8.2f", matriz[i][j]);
            }
            System.out.println();
        }

        double somaDasDiagonais = calcularSomaDiagonais(matriz);

        System.out.printf("A soma dos elementos das diagonais é: %.2f\n", somaDasDiagonais);

        sc.close();
    }

    public static void preencherMatriz(double[][] matriz, Scanner scanner) {
        System.out.println("\nPor favor, preencha os valores da matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                while (true) {
                    try {
                        System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                        matriz[i][j] = scanner.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("--> Erro: Valor inválido. Digite um número.");
                        scanner.next();
                    }
                }
            }
        }
    }

    public static double calcularSomaDiagonais(double[][] matriz) {
        double soma = 0;
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            soma += matriz[i][i];
            if (i != (n - 1 - i)) {
                soma += matriz[i][n - 1 - i];
            }
        }
        return soma;
    }
}
