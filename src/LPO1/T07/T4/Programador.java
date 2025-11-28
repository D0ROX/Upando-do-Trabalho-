package LPO1.T07.T4;

public class Programador extends Funcionario {
    public Programador(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public double getBonus() {
        return this.getSalario() * 0.8;
    }
}