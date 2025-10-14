package ATV3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATV3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double[] indices = new double[7];

        String[] nomesDosDias = {
                "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
                "Quinta-feira", "Sexta-feira", "Sábado"
        };

        double soma = 0;

            for(int i = 0; i < indices.length; i++){
                try{
                    System.out.println("Informe o indice para -> " + nomesDosDias[i]);
                    double valorLido = sc.nextDouble();
                    indices[i] = valorLido;
                    soma += valorLido;

                } catch(InputMismatchException e){
                    System.out.println("Valor inálido, por favor insira um valor válido. ");
                    sc.next();

                    i--;
                }
            }


        double media = soma / indices.length;

        double minimo = indices[0];
        double maximo = indices[0];
        int indiceDiaMaximo = 0;
        int indiceDiaMinimo = 0;

        for(int i = 1; i < indices.length; i++){
            if(indices[i] > maximo){
                maximo = indices[i];
                indiceDiaMaximo = i;
            }
            for(int j = 1; j < indices.length; j++){
                if (indices[i] < minimo){
                    minimo = indices[i];
                    indiceDiaMinimo = j;
                }
            }
        }

        System.out.printf("Índice pluviométrico MÉDIO: %.2f mm\n", media);
        System.out.printf("Índice pluviométrico MÁXIMO: %.2f mm (ocorrência na %s)\n", maximo, nomesDosDias[indiceDiaMaximo]);
        System.out.printf("Índice pluviométrico MÍNIMO: %.2f mm (ocorrência no %s)\n", minimo, nomesDosDias[indiceDiaMinimo]);

    }
}
