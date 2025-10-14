package ATV3;

import java.util.Scanner;

public class ATV5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String fraseOriginal = sc.nextLine();

        String textoLimpo = fraseOriginal.toLowerCase().replaceAll("[^a-z0-9]", "");

        String textoInvertido =  new StringBuilder(textoLimpo).reverse().toString();

        if(!textoLimpo.isEmpty() && textoLimpo.equals(textoInvertido)){
            System.out.println("A frase é um palíndromo! ");
        } else {
            System.out.println("A frase não é um palíndromo! ");
        }

        sc.close();
    }
}
