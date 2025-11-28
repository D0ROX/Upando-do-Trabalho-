package LPO1.T07.T4;

// Modelo abstrato de funcionário; define contrato de bônus
public abstract class Funcionario {

    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    // Cada cargo define sua regra de bônus
    public abstract double getBonus();

    // Acesso somente-leitura (imutabilidade parcial)
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public double getSalario() { return salario; }
}

