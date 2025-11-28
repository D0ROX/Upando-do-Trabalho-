package LPO1.T08.T3;

// Professor especializado de Pessoa
public class Professor extends Pessoa {

    private String departamento;
    private double salario;

    // Composição: disciplinas ministradas (limite máximo)
    private Disciplina[] disciplinasMinistradas;
    private int numDisciplinasMinistradas;

    public Professor(String nome, String cpf, String endereco,
                     String departamento, double salario, int maxDisciplinas) {
        super(nome, cpf, endereco);
        this.departamento = departamento;
        this.salario = salario;
        this.disciplinasMinistradas = new Disciplina[maxDisciplinas];
        this.numDisciplinasMinistradas = 0;
    }

    // Reuso do nome definido em Pessoa
    public String getNome() {
        return super.getNome();
    }

    // Associa disciplina ao professor
    public String adicionaDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            return "Erro: Disciplina inválida.";
        }
        if (numDisciplinasMinistradas >= disciplinasMinistradas.length) {
            return "Erro: Professor atingiu o limite de disciplinas.";
        }
        // Evita duplicidade
        for (int i = 0; i < numDisciplinasMinistradas; i++) {
            if (disciplinasMinistradas[i] == disciplina) {
                return "Aviso: Disciplina já associada a este professor.";
            }
        }

        disciplinasMinistradas[numDisciplinasMinistradas++] = disciplina;
        disciplina.setProfessor(this);
        return "Disciplina " + disciplina.getNome() + " associada ao Prof. " + getNome();
    }
}

