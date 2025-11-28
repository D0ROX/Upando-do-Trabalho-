package LPO1.T06.T2;

public class Aluno extends Pessoa {

    // Dados do aluno
    private String matricula;
    private String curso;
    private int periodo;

    // Relação: Aluno tem Disciplinas
    private Disciplina[] disciplinasMatriculadas;
    private int numDisciplinasMatriculadas;

    public Aluno(String nome, String cpf, String endereco,
                 String matricula, String curso, int periodo, int maxDisciplinas) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.disciplinasMatriculadas = new Disciplina[maxDisciplinas];
        this.numDisciplinasMatriculadas = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    // Matricula o aluno na disciplina (evita duplicatas)
    public String fazMatricula(Disciplina disciplina) {
        if (disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina. Procure a secretaria.";
        }
        if (numDisciplinasMatriculadas >= disciplinasMatriculadas.length) {
            return "Quantidade de disciplinas excedida.";
        }
        // evita duplicidade
        for (int i = 0; i < numDisciplinasMatriculadas; i++) {
            if (disciplinasMatriculadas[i].getCodigo().equalsIgnoreCase(disciplina.getCodigo())) {
                return "Aluno já matriculado nesta disciplina.";
            }
        }
        disciplinasMatriculadas[numDisciplinasMatriculadas++] = disciplina;
        disciplina.adicionaAluno(this);
        return "Matrícula na disciplina \"" + disciplina.getNome() + "\" executada.";
    }

    // Cancela por nome da disciplina
    public String cancelarMatricula(String nomeDisciplina) {
        int idx = -1;
        for (int i = 0; i < numDisciplinasMatriculadas; i++) {
            Disciplina d = disciplinasMatriculadas[i];
            if (d != null && d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return "Aluno não está matriculado em " + nomeDisciplina + ".";
        }

        Disciplina disciplina = disciplinasMatriculadas[idx];

        for (int i = idx; i < numDisciplinasMatriculadas - 1; i++) {
            disciplinasMatriculadas[i] = disciplinasMatriculadas[i + 1];
        }
        disciplinasMatriculadas[--numDisciplinasMatriculadas] = null;

        disciplina.removeAluno(this);
        return "Cancelamento da matrícula de " + nomeDisciplina + " realizado.";
    }

    // Impressão resumida
    public String imprime() {
        String cabecalho = "-----------------------------------------------------------------\n";
        String dadosPessoa = "Nome do Aluno: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Endereço: " + getEndereco() + "\n";

        String dadosAluno = "Matricula: " + matricula + "\n"
                + "Curso: " + curso + "\n"
                + "Periodo: " + periodo + "\n";

        StringBuilder sb = new StringBuilder();
        if (numDisciplinasMatriculadas == 0) {
            sb.append("Nenhuma disciplina matriculada.");
        } else {
            for (int i = 0; i < numDisciplinasMatriculadas; i++) {
                Disciplina d = disciplinasMatriculadas[i];
                sb.append(d.getNome());
                if (d.getProfessor() != null) {
                    sb.append(" (Prof. ").append(d.getProfessor().getNome()).append(")");
                }
                if (i < numDisciplinasMatriculadas - 1) sb.append("; ");
            }
        }

        String disciplinas = "Disciplinas Matriculadas: " + sb + "\n";
        String rodape = "-----------------------------------------------------------------\n";
        return cabecalho + dadosPessoa + dadosAluno + disciplinas + rodape;
    }
}

