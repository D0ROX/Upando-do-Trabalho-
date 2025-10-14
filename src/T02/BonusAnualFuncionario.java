package T02;

import java.util.Scanner;

public class BonusAnualFuncionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o seu cargo (diretor, gerente, analista, programador, auxiliar de limpeza)");
        String cargo = sc.next();

        System.out.println("Informe o valor do seu salário atual: ");
        double salario = sc.nextDouble();

        double bonus = 0;

        if(cargo.equalsIgnoreCase("diretor")){
            System.out.println("Informe quantos departamentos você gerencia: ");
            int quantDepartamentos = sc.nextInt();

            bonus = (salario*4) + 3000 * quantDepartamentos;

        } else if(cargo.equalsIgnoreCase("gerente")){
            System.out.println("Informe quantas pessoas você gerência: ");
            int quantPessoas = sc.nextInt();

            bonus = (salario*2) + quantPessoas * 100;

        } else if(cargo.equalsIgnoreCase("analista")){
            bonus = salario;

        } else if(cargo.equalsIgnoreCase("programador")){
            bonus =  salario*0.8;

        } else if(cargo.equalsIgnoreCase("auxiliar de limpeza")){
            bonus = salario*0.5;
        }
        System.out.printf("De acordo com com seu cargo e com as regrasda empresa, seu bonus é: R$ %.2f", bonus);
    }
}
