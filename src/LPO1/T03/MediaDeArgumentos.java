package LPO1.T03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MediaDeArgumentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char fim = ' ';
        int cont = 0;
        double soma  = 0;
        double valores = 0;

        System.out.println("Informe os valores (Digite 'S'  para sair): ");


            while(true){
                System.out.println("Informe o valor: ");
                try{
                    valores = sc.nextDouble();
                    soma += valores;
                    cont++;
                    double media = soma /cont;

                    System.out.printf("Media -> %.2f\n ", media);

                } catch (InputMismatchException e){
                    String entrada = sc.next();
                    if (entrada.equalsIgnoreCase("S")){
                        break;
                    } else {
                        System.out.println("Entrada inválida, digite um número válido: ");
                    }
                }

            }

        if (cont > 0){
            System.out.printf("Média final: %.2f\n", soma / cont);
        } else {
            System.out.println("Nenhum valor válido foi informado.");
        }

            sc.close();
    }
}
