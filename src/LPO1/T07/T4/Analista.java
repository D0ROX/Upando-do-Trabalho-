package LPO1.T07.T4;

public class Analista extends Funcionario {
    public Analista(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public double getBonus() {
        return this.getSalario() * 1.0;
    }
}
