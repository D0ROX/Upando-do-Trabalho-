package AlunosENotas;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAlunos {

    // Método para cadastrar alunos e retornar a lista de alunos
    public ArrayList<Aluno> cadastrarAlunos() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.print("Informe o nome do aluno (S para sair): ");
            String nome = sc.nextLine();

            if (nome.equalsIgnoreCase("S")) {
                break; // sai do loop
            }

            Aluno aluno = new Aluno(nome); // cria objeto Aluno
            alunos.add(aluno);             // adiciona à lista
        }

        // Não fechamos o Scanner aqui para evitar fechar System.in
        return alunos;
    }
}
