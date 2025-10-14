package ATV3;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ATV4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantFuncionoarios = 0;
        double soma = 0;
        double media = 0;
        String nomeTemp;

        while(true){
            try{
                System.out.println("Quantos funcionários serão cadastrados? ");
                quantFuncionoarios = sc.nextInt();
                sc.nextLine();

                if(quantFuncionoarios > 0){
                    break;
                } else {
                    System.out.println("O número de funcionários deve serm maior que zero! ");
                }
            } catch(InputMismatchException e){
                System.out.println("Entrada inválida, por favor digite um número inteiro. ");

                sc.next();
            }
        }

        String [] funcionarios = new String[quantFuncionoarios];
        double [] salarios = new double[quantFuncionoarios];

        for (int i = 0; i < quantFuncionoarios; i++) {

            while (true){

                    System.out.println("Informe o nome do funcionário: (Insira pelo menos 3 caracteres). ");
                    nomeTemp = sc.nextLine().trim();

                    if(nomeTemp.isEmpty()){
                        System.out.println("--> Entreada inválida, o nome n~~ao pode ser vazio. ");
                    }

                    if(nomeTemp.length()>=3 && !nomeTemp.matches(".*\\d.*")){
                        funcionarios[i] = nomeTemp;
                        break;
                    } else {
                        if(nomeTemp.length()<3){
                            System.out.println("--> Nome inválido! o nome deve ter no mínimo 3 caracteres. ");
                        } else{
                            System.out.println("Nome inválido, o nome não pode conter números. ");
                        }
                    }
                 }

           while (true){
               try{
                   System.out.println("Informe o saláro do funcionário: ");
                   salarios[i] = sc.nextDouble();
                   soma += salarios[i];
                   sc.nextLine();
                   break;
               }  catch(InputMismatchException e){
                   System.out.println("Entrada inválida, por favor digite um número. ");

                   sc.next();
               }
           }
        }

            media = soma / quantFuncionoarios;


        System.out.println("------Lista de Funcionários Cadastrados------");
        for(int i = 0; i < funcionarios.length; i++){
            if(salarios[i] > media){
                System.out.printf("Media(%.2f) | Nome: %s | Salário: %.2f\n",media, funcionarios[i],  salarios[i]);
            }

            sc.close();
        }


    }
}
