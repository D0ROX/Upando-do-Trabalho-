package T05.T1;

public class Aluno {

    // (a) Atributos
    private String nome;
    private String matricula;
    private String curso;
    private int periodo;
    private String endereco;

    // Guarda os nomes das disciplinas
    private String[] disciplinasMatriculadas;
    // Conta quantas disciplinas estão na lista
    private int numDisciplinasMatriculadas;

    // (b) Construtor. É chamado quando um new Aluno() acontece.
    public Aluno(String nome, String matricula, String curso, int periodo, int quantidadeDisciplinasPermitidas) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;

        // (b) Define o tamanho da lista de disciplinas
        this.disciplinasMatriculadas = new String[quantidadeDisciplinasPermitidas];

        // O contador de disciplinas começa em 0
        this.numDisciplinasMatriculadas = 0;
        this.endereco = "";
    }

    // Retorna o nome do aluno
    public String getNome() {
        return this.nome;
    }

    // Retorna a matrícula do aluno
    public String getMatricula() {
        return this.matricula;
    }

    // Atualiza o endereço do aluno
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // (c) Tenta matricular o aluno em uma disciplina
    public String fazMatricula(String disciplina) {

        // 1. Verifica se o limite de disciplinas é 0
        if (this.disciplinasMatriculadas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        }

        // 2. Verifica se a lista de disciplinas já está cheia
        if (this.numDisciplinasMatriculadas >= this.disciplinasMatriculadas.length) {
            String msg = "Quantidade de disciplinas excedida. O limite de "
                    + "disciplinas para este aluno é de "
                    + this.disciplinasMatriculadas.length + " disciplina(s). "
                    + "Se desejar, cancele a matrícula de uma das "
                    + "disciplinas e faça a nova matrícula.";
            return msg;
        }

        // 3. Adiciona a disciplina na próxima posição livre
        this.disciplinasMatriculadas[this.numDisciplinasMatriculadas] = disciplina;
        // Aumenta o contador
        this.numDisciplinasMatriculadas++;

        return "Matrícula na disciplina \"" + disciplina + "\" executada.";
    }

    // (c) Tenta remover uma disciplina da lista
    public String cancelarMatricula(String disciplina) {
        // Guarda a posição da disciplina. -1 significa "não achou".
        int indiceEncontrado = -1;

        // 1. Procura a disciplina na lista (só nas posições usadas)
        for (int i = 0; i < this.numDisciplinasMatriculadas; i++) {
            if (this.disciplinasMatriculadas[i] != null && this.disciplinasMatriculadas[i].equals(disciplina)) {
                indiceEncontrado = i; // Guarda a posição
                break; // Para de procurar
            }
        }

        // 2. Se não encontrou a disciplina, retorna erro
        if (indiceEncontrado == -1) {
            return "Aluno não está matriculado na disciplina " + disciplina +
                    ", portanto não é possível cancelar esta matrícula.";
        }

        // 3. "Empurra" os itens da lista para cobrir o espaço vazio
        for (int i = indiceEncontrado; i < this.numDisciplinasMatriculadas - 1; i++) {
            this.disciplinasMatriculadas[i] = this.disciplinasMatriculadas[i + 1];
        }

        // 4. Limpa a última posição e diminui o contador de disciplinas
        this.disciplinasMatriculadas[this.numDisciplinasMatriculadas - 1] = null;
        this.numDisciplinasMatriculadas--;

        return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
    }

    // (c) Monta uma String com todos os dados do aluno
    public String imprime() {
        // Monta o texto parte por parte
        String cabecalho = "-----------------------------------------------------------------\n";
        String dados = "Nome do Aluno: " + this.nome + "\n"
                + "Matricula: " + this.matricula + "\n"
                + "Curso: " + this.curso + "\n"
                + "Periodo: " + this.periodo + "\n"
                + "Endereço: " + this.endereco + "\n";

        // Monta o texto das disciplinas
        String strDisciplinas = "";
        // Verifica se o aluno não tem disciplinas
        if (this.numDisciplinasMatriculadas == 0) {
            strDisciplinas = "Nenhuma disciplina matriculada.";
        } else {
            // Adiciona cada disciplina na string
            for (int i = 0; i < this.numDisciplinasMatriculadas; i++) {
                strDisciplinas += this.disciplinasMatriculadas[i];
                // Adiciona "; " para separar, menos na última
                if (i < this.numDisciplinasMatriculadas - 1) {
                    strDisciplinas += "; ";
                }
            }
        }

        String disciplinas = "Disciplinas Matriculadas: " + strDisciplinas + "\n";
        String rodape = "-----------------------------------------------------------------\n";

        // Retorna o texto completo
        return cabecalho + dados + disciplinas + rodape;
    }
}
