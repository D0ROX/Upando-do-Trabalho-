package AlunosENotas;

import java.util.Scanner;

public class CadastroNotas {

    // Método que cadastra notas para um aluno específico
    public void cadastrarNotas(Aluno aluno) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Informe a nota do aluno " + aluno.getNome() + " (S para sair): ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("S")) {
                break; // sai do loop
            }

            try {
                double nota = Double.parseDouble(entrada);
                aluno.adicionarNota(nota); // adiciona a nota ao aluno
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
            }
        }

        // Não fechamos o Scanner aqui para não fechar System.in
    }
}
