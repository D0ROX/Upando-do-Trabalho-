package ATV3;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ATV4 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);

        int quantidadeFuncionarios = 0;
        double somaSalarios = 0.0;

        while (true) {
            try {
                System.out.print("Quantos funcionários serão cadastrados? ");
                quantidadeFuncionarios = sc.nextInt();
                sc.nextLine();
                if (quantidadeFuncionarios > 0) {
                    break;
                } else {
                    System.out.println("O número de funcionários deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor digite um número inteiro.");
                sc.next();
            }
        }

        String[] funcionarios = new String[quantidadeFuncionarios];
        double[] salarios = new double[quantidadeFuncionarios];

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            while (true) {
                System.out.print("Informe o nome do funcionário (mínimo 3 caracteres, sem números): ");
                String nomeTemp = sc.nextLine().trim();
                if (nomeTemp.isEmpty()) {
                    System.out.println("--> Entrada inválida, o nome não pode ser vazio.");
                    continue;
                }
                if (nomeTemp.length() < 3) {
                    System.out.println("--> Nome inválido! O nome deve ter no mínimo 3 caracteres.");
                    continue;
                }
                if (nomeTemp.matches(".*\\d.*")) {
                    System.out.println("--> Nome inválido, o nome não pode conter números.");
                    continue;
                }
                funcionarios[i] = nomeTemp;
                break;
            }

            while (true) {
                try {
                    System.out.print("Informe o salário do funcionário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    salarios[i] = salario;
                    somaSalarios += salario;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida, por favor digite um número (use vírgula ou ponto conforme seu sistema).");
                    sc.next();
                }
            }
        }

        double media = somaSalarios / quantidadeFuncionarios;

        System.out.println();
        System.out.println("------ Lista de Funcionários com salário acima da média ------");
        System.out.printf("Média salarial: %.2f%n", media);

        boolean alguemAcima = false;
        for (int i = 0; i < funcionarios.length; i++) {
            if (salarios[i] > media) {
                System.out.printf("Nome: %s | Salário: %.2f%n", funcionarios[i], salarios[i]);
                alguemAcima = true;
            }
        }

        if (!alguemAcima) {
            System.out.println("Nenhum funcionário com salário acima da média.");
        }

        sc.close();
    }
}
