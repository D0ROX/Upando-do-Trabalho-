package LPO1.T06.T5;

import java.util.Scanner;

public class TesteVeiculoUnico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Veiculo meuVeiculo = null;

        System.out.println("Criar Um Veículo: ");
        System.out.println("Qual tipo de veículo deseja criar?");
        System.out.println("1 - Carro");
        System.out.println("2 - Avião");
        System.out.println("3 - Trem");
        System.out.println("4 - Barco");
        System.out.print("Escolha: ");

        int escolha = lerInt(sc);

        if (escolha == 1) {
            System.out.println("Criando um Carro...");
            meuVeiculo = new Carro("Ford", "Ka", 2020, 4, "ABC-1234");
        } else if (escolha == 2) {
            System.out.println("Criando um Avião...");
            meuVeiculo = new Aviao("Boeing", "747", 2018, 4, "Azul");
        } else if (escolha == 3) {
            System.out.println("Criando um Trem...");
            meuVeiculo = new Trem("Hitachi", "Série 8000", 2001, 60, 8);
        } else if (escolha == 4) {
            System.out.println("Criando um Barco...");
            meuVeiculo = new Barco("Beneteau", "Oceanis 38", 2017, 2.0, "Vento Livre");
        } else {
            System.out.println("Opção inválida.");
        }

        if (meuVeiculo != null) {
            System.out.println("\nRealizando o movimento:");
            meuVeiculo.andar();
        }

        sc.close();
    }

    private static int lerInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Tente novamente: ");
            }
        }
    }
}
