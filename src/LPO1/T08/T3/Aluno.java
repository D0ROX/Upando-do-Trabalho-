package LPO1.T08.T3;

// Aluno especializado de Pessoa
public class Aluno extends Pessoa {

    private String matricula;
    private String curso;
    private int periodo;

    // Disciplinas cursadas (capacidade fixa)
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

    public String getMatricula() { return matricula; }

    // Matricula bidirecional com validações básicas
    public String fazMatricula(Disciplina disciplina) {
        if (disciplina == null) return "Erro: Disciplina inválida.";
        if (disciplinasMatriculadas.length == 0) return "Limite de disciplinas é 0; procure a secretaria.";
        if (numDisciplinasMatriculadas >= disciplinasMatriculadas.length) return "Quantidade de disciplinas excedida.";

        // Evita duplicidade
        for (int i = 0; i < numDisciplinasMatriculadas; i++) {
            if (disciplinasMatriculadas[i] == disciplina) {
                return "Aviso: Aluno já matriculado nesta disciplina.";
            }
        }

        disciplinasMatriculadas[numDisciplinasMatriculadas++] = disciplina;
        String retornoDisciplina = disciplina.adicionaAluno(this);
        // Se a disciplina estiver lotada, desfaz inclusão aqui
        if (retornoDisciplina.startsWith("Erro")) {
            disciplinasMatriculadas[--numDisciplinasMatriculadas] = null;
            return retornoDisciplina;
        }
        return "Matrícula na disciplina \"" + disciplina.getNome() + "\" executada.";
    }

    // Cancela por nome de disciplina
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
        return "Cancelamento da matrícula de " + nomeDisciplina + " executado.";
    }

    // Impressão consolidada
    public String imprime() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------------------------------\n");
        sb.append("Nome do Aluno: ").append(getNome()).append("\n")
                .append("CPF: ").append(getCpf()).append("\n")
                .append("Endereço: ").append(getEndereco()).append("\n");
        sb.append("Matricula: ").append(matricula).append("\n")
                .append("Curso: ").append(curso).append("\n")
                .append("Periodo: ").append(periodo).append("\n");

        sb.append("Disciplinas Matriculadas: ");
        if (numDisciplinasMatriculadas == 0) {
            sb.append("Nenhuma disciplina matriculada.\n");
        } else {
            for (int i = 0; i < numDisciplinasMatriculadas; i++) {
                Disciplina d = disciplinasMatriculadas[i];
                sb.append(d.getNome());
                if (d.getProfessor() != null) {
                    sb.append(" (Prof. ").append(d.getProfessor().getNome()).append(")");
                }
                if (i < numDisciplinasMatriculadas - 1) sb.append("; ");
            }
            sb.append("\n");
        }
        sb.append("-----------------------------------------------------------------\n");
        return sb.toString();
    }
}