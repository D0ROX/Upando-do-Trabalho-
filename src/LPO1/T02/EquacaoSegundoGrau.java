package LPO1.T02;

import java.util.Scanner;

public class EquacaoSegundoGrau {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor de a: ");
        double a = sc.nextDouble();

        System.out.println("Informe o valor de b: ");
        double b = sc.nextDouble();

        System.out.println("Informe o valor de c: ");
        double c = sc.nextDouble();

        double delta = Math.pow(b,2) - 4 * a* c;

        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

        System.out.println("As raizes quadradas são: ");
        System.out.println("x1: " + x1 );
        System.out.println("x2: " + x2 );
        }
    }