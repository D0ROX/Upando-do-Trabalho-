package LPO1.T06.T5;

import java.util.Scanner;

public class SistemaDeFrota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos veículos deseja informar? ");
        int total = lerInt(sc);

        Veiculo[] frota = new Veiculo[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nVeículo " + (i + 1));
            System.out.println("Qual o tipo?");
            System.out.println("1-Carro | 2-Trem | 3-Aviao | 4-Barco");
            System.out.print("Tipo: ");
            int tipo = lerInt(sc);

            System.out.print("Marca: ");
            String marca = sc.nextLine().trim();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine().trim();
            System.out.print("Ano: ");
            int ano = lerInt(sc);

            switch (tipo) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine().trim();
                    frota[i] = new Carro(marca, modelo, ano, 4, placa);
                }
                case 2 -> {
                    System.out.print("Número de Vagões: ");
                    int vagoes = lerInt(sc);
                    // rodas simbólicas para trem
                    frota[i] = new Trem(marca, modelo, ano, 100, vagoes);
                }
                case 3 -> {
                    System.out.print("Companhia Aérea: ");
                    String cia = sc.nextLine().trim();
                    frota[i] = new Aviao(marca, modelo, ano, 2, cia);
                }
                case 4 -> {
                    System.out.print("Nome do Barco: ");
                    String nomeBarco = sc.nextLine().trim();
                    frota[i] = new Barco(marca, modelo, ano, 5.0, nomeBarco);
                }
                default -> {
                    System.out.println("Tipo inválido. Posição " + i + " ficará vazia.");
                }
            }
        }

        System.out.println("   MOVIMENTANDO TODOS OS VEÍCULOS DA FROTA");

        for (Veiculo v : frota) {
            if (v != null) {
                v.andar(); // polimorfismo
            }
        }

        sc.close();
    }

    // Leitura segura de int (re-pede até ser válido)
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

