package LPO1.T06.T1;

// AuxiliarLimpeza herda de Funcionario
public class AuxiliarLimpeza extends Funcionario {

    // Construtor
    public AuxiliarLimpeza(String nome, String cpf, double salario) {
        super(nome, cpf, salario); // chama construtor da base
    }

    // Bônus do Auxiliar: 0.5x salário
    @Override
    public double getBonus() {
        return getSalario() * 0.5;
    }
}

