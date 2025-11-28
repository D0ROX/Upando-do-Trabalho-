package LPO1;

import java.util.Scanner;

public class ATV1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String entrada;
        double media = 0;
        double soma = 0;
        int cont = 0;

        System.out.print("Digite números para cacular a media: (Digite S para sair) ");



        while(true){
            System.out.println("Digite um valor: ");
            entrada = sc.next();

            if(entrada.equalsIgnoreCase("s")){
                break;
            }

            try{

                double valor = Double.parseDouble(entrada);

                soma += valor;
                cont++;

            } catch(NumberFormatException e){
                System.out.println("'" + entrada + "'" + " é um argumento inválido, por favor digite um número real.");
            }
                if(cont > 0){
                    media = soma/cont;
                    System.out.printf("%.2f%n", media);
                } else {
                    System.out.println("Nenhum valor válido foi inserido. ");
                }
        }
        sc.close();
    }
}
