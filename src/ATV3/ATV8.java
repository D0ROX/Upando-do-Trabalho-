package ATV3;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ATV8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroDeAmostras = 0;


        while (true) {
            try {
                System.out.print("Informe o número de amostras (mínimo 2): ");
                numeroDeAmostras = sc.nextInt();
                if (numeroDeAmostras > 1) {
                    break;
                } else {
                    System.out.println("--> Erro: Você precisa de pelo menos 2 amostras para o cálculo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("--> Erro: Entrada inválida. Por favor, digite um número inteiro.");
                sc.next();
            }
        }

        double[] amostras = new double[numeroDeAmostras];
        System.out.println("\nPor favor, informe os valores de cada amostra:");

        for (int i = 0; i < numeroDeAmostras; i++) {
            while (true) {
                try {
                    System.out.print("Amostra " + (i + 1) + ": ");
                    amostras[i] = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("--> Erro: Valor inválido. Digite um número decimal.");
                    sc.next();
                }
            }
        }

        double soma = 0.0;
        for (double amostra : amostras) {
            soma += amostra;
        }
        double media = soma / numeroDeAmostras;

        double somaDosQuadrados = 0.0;
        for (double amostra : amostras) {
            somaDosQuadrados += Math.pow(amostra - media, 2);
        }
        double variancia = somaDosQuadrados / (numeroDeAmostras - 1);

        double desvioPadrao = Math.sqrt(variancia);

        System.out.printf("Número de Amostras: %d\n", numeroDeAmostras);
        System.out.printf("Média das amostras: %.4f\n", media);
        System.out.printf("Variância amostral: %.4f\n", variancia);
        System.out.printf("Desvio Padrão Amostral: %.4f\n", desvioPadrao);

        sc.close();
    }
}
