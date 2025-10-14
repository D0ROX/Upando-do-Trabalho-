package T02;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro positivo: ");
        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        System.out.print("Série de fibonacci: ");

        while (a <= n) {
            System.out.print(a + " ");
            int proximo = a + b;
            a = b;
            b = proximo;
        }

    }
}
