package LPO1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATV6 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            double[][] matriz = new double[3][3];

            System.out.println("Por favor, informe os 9 elementos da matriz.");

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    while (true) {
                        try {
                            System.out.print("Informe o elemento da linha " + (i + 1) + ", coluna " + (j + 1) + ": ");
                            matriz[i][j] = sc.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("--> Erro: Entrada inválida. Por favor, digite um número.");
                            sc.next();
                        }
                    }
                }
            }

            System.out.println("\nA matriz que você informou foi:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf("%8.2f", matriz[i][j]);
                }
                System.out.println();
            }

            double somaPrincipais = (matriz[0][0] * matriz[1][1] * matriz[2][2]) +
                    (matriz[0][1] * matriz[1][2] * matriz[2][0]) +
                    (matriz[0][2] * matriz[1][0] * matriz[2][1]);

            double somaSecundarias = (matriz[2][0] * matriz[1][1] * matriz[0][2]) +
                    (matriz[2][1] * matriz[1][2] * matriz[0][0]) +
                    (matriz[2][2] * matriz[1][0] * matriz[0][1]);

            double determinante = somaPrincipais - somaSecundarias;

            System.out.printf("O determinante da matriz é: %.2f\n", determinante);

            sc.close();
        }

    }

