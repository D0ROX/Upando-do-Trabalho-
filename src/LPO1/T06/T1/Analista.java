package LPO1.T06.T1;

// Analista herda de Funcionario
public class Analista extends Funcionario {

    // Construtor
    public Analista(String nome, String cpf, double salario) {
        super(nome, cpf, salario); // encadeia para o construtor da base
    }

    // Bônus do Analista: 1x salário
    @Override
    public double getBonus() {
        return getSalario();
    }
}

