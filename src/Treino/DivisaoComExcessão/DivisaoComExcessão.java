package Treino.DivisaoComExcessão;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisaoComExcessão {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = 0;
        int n2 = 0;
        int resultado = 0;

        while (true){
            try{
                System.out.println("Informe um número: ");
                n1 = sc.nextInt();

                System.out.println("Informe um número: ");
                n2 = sc.nextInt();

                resultado = n1 / n2;
                System.out.printf(n1 + "/" + n2 );
                System.out.println("Resultado: " + resultado);
                break;

            } catch(InputMismatchException e){
                System.out.println("Entrada inválida, digite um número inteiro. ");
                sc.nextLine();
            } catch(ArithmeticException e){
                System.out.println("Erro: não é possível dividir por zero! ");
            }
        }

    }
}
