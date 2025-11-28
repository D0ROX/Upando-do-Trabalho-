package LPO1.T06.T2;

// Professor herda de Pessoa
public class Professor extends Pessoa {

    // Dados do professor
    private String departamento;
    private double salario;

    // Relação: Professor tem Disciplinas
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

    // Encaminha para a base
    public String getNome() {
        return super.getNome();
    }

    // Adiciona disciplina (com vínculo inverso)
    public String adicionaDisciplina(Disciplina disciplina) {
        if (numDisciplinasMinistradas >= disciplinasMinistradas.length) {
            return "Erro: limite de disciplinas atingido.";
        }
        disciplinasMinistradas[numDisciplinasMinistradas++] = disciplina;
        disciplina.setProfessor(this);
        return "Disciplina " + disciplina.getNome() + " associada ao Prof. " + getNome();
    }
}

