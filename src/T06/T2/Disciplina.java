package T06.T2;

public class Disciplina {

    private String nome;
    private String codigo;

    // 1:N (um professor, várias disciplinas)
    private Professor professor;

    // N:M (vários alunos por disciplina)
    private Aluno[] alunosMatriculados;
    private int numAlunosMatriculados;

    public Disciplina(String nome, String codigo, int maxAlunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.alunosMatriculados = new Aluno[maxAlunos];
        this.numAlunosMatriculados = 0;
        this.professor = null;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Adiciona aluno (sem duplicar)
    public String adicionaAluno(Aluno aluno) {
        if (numAlunosMatriculados >= alunosMatriculados.length) {
            return "Erro: Disciplina lotada.";
        }
        // evita matrícula duplicada
        for (int i = 0; i < numAlunosMatriculados; i++) {
            if (alunosMatriculados[i].getMatricula().equals(aluno.getMatricula())) {
                return "Aluno já matriculado.";
            }
        }
        alunosMatriculados[numAlunosMatriculados++] = aluno;
        return "Aluno adicionado à disciplina.";
    }

    // Remove aluno (compacta o array)
    public void removeAluno(Aluno aluno) {
        int idx = -1;
        for (int i = 0; i < numAlunosMatriculados; i++) {
            if (alunosMatriculados[i].getMatricula().equals(aluno.getMatricula())) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            for (int i = idx; i < numAlunosMatriculados - 1; i++) {
                alunosMatriculados[i] = alunosMatriculados[i + 1];
            }
            alunosMatriculados[--numAlunosMatriculados] = null;
        }
    }
}
