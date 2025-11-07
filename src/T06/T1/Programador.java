package T06.T1;

// Programador herda de Funcionario
public class Programador extends Funcionario {

    // Construtor
    public Programador(String nome, String cpf, double salario) {
        super(nome, cpf, salario); // chama construtor da base
    }

    // Bônus do Programador: 0.8x salário
    @Override
    public double getBonus() {
        return getSalario() * 0.8;
    }
}

