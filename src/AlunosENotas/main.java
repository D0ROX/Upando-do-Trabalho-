package AlunosENotas;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        CadastroAlunos cadAlunos = new CadastroAlunos();
        CadastroNotas cadNotas= new CadastroNotas();

        ArrayList<Aluno> alunos = cadAlunos.cadastrarAlunos();

        for (Aluno aluno : alunos) {
            System.out.println("\nCadastrando notas para o aluno: " + aluno.getNome());
            cadNotas.cadastrarNotas(aluno);
        }

        System.out.println("\n=== Alunos Cadastrados ===");
        for (Aluno aluno : alunos) {
            aluno.mostrarAluno();
        }


    }
}
