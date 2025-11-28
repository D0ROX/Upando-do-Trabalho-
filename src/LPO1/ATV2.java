package LPO1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATV2 {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        int[] conjunto = new int [20];
        int soma = 0;

        System.out.println("Informe 20 números inteiros: ");

        for(int i = 0; i < conjunto.length; i++) {
            System.out.println("Informe um número: ");


            try{
                int numeroLido = sc.nextInt();
                conjunto[i] =  numeroLido;

                if(numeroLido % 2 == 0){
                    soma += numeroLido;
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor digite um número inteiro.");

                sc.next();

                i--;
            }

            }
            System.out.printf("A soma dos numeros pares é: %d\n", soma);

            sc.close();
        }
    }


