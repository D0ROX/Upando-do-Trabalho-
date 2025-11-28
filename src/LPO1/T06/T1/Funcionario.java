package LPO1.T06.T1;

// Classe base abstrata para funcionários
public abstract class Funcionario {

    // Dados básicos
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    // Cada subclasse define como calcula o bônus
    public abstract double getBonus();

    // Acesso somente leitura
    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getCpf() {
        return cpf;
    }
}

