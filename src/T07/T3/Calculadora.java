package T07.T3;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double soma = 0.0;
        int contador = 0;

        System.out.println("Informe os números na sequência solicitada.");
        System.out.println("Para sair digite 'S'.");

        // Loop até o usuário digitar o sentinela (S)
        while (true) {
            System.out.print("Numero " + (contador + 1) + "=");
            String input = sc.nextLine().trim();

            // Sentinela (encerra a leitura)
            if (input.equalsIgnoreCase("S")) {
                break;
            }

            // Valida número: acumula apenas entradas válidas
            try {
                double numero = Double.parseDouble(input);
                soma += numero;
                contador++;
            } catch (NumberFormatException e) {
                System.out.println("Erro de entrada.");
                System.out.println(input + " não é um numérico válido. Tente novamente ou digite S para sair.");
            }
        }

        System.out.println("---------------------------------");

        if (contador > 0) {
            double media = soma / contador;
            System.out.printf("A soma dos números digitados é=%.1f%n", soma);
            System.out.printf("A média dos números digitados é=%.1f%n", media);
        } else {
            System.out.println("Nenhum número válido foi digitado.");
        }

        sc.close();
    }
}

