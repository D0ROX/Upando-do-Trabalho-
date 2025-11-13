package T08.T3;

public class Disciplina {

    private String nome;
    private String codigo;

    // 1:N - um professor ministra várias disciplinas
    private Professor professor;

    // N:M - vários alunos em várias disciplinas (lado desta disciplina)
    private Aluno[] alunosMatriculados;
    private int numAlunosMatriculados;

    public Disciplina(String nome, String codigo, int maxAlunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.alunosMatriculados = new Aluno[maxAlunos];
        this.numAlunosMatriculados = 0;
        this.professor = null;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    // Adiciona aluno à disciplina (evita duplicidade e respeita capacidade)
    public String adicionaAluno(Aluno aluno) {
        if (aluno == null) return "Erro: Aluno inválido.";
        if (numAlunosMatriculados >= alunosMatriculados.length) return "Erro: Disciplina lotada.";

        for (int i = 0; i < numAlunosMatriculados; i++) {
            if (alunosMatriculados[i].getMatricula().equals(aluno.getMatricula())) {
                return "Aviso: Aluno já matriculado nesta disciplina.";
            }
        }
        alunosMatriculados[numAlunosMatriculados++] = aluno;
        return "Aluno adicionado à disciplina.";
    }

    // Remove aluno por matrícula, mantendo o array compacto
    public void removeAluno(Aluno aluno) {
        if (aluno == null) return;
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

