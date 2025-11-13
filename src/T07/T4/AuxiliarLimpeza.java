package T07.T4;

public class AuxiliarLimpeza extends Funcionario {
    public AuxiliarLimpeza(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public double getBonus() {
        return this.getSalario() * 0.5;
    }
}
