package LPO1.T07.T4;

// Exige no mínimo 2 departamentos; violações lançam exceção verificada
public class Diretor extends Funcionario {

    private Departamento[] departamentos;

    public Diretor(String nome, String cpf, double salario, Departamento[] departamentos)
            throws ValidacaoEquipeException {
        super(nome, cpf, salario);
        if (departamentos == null || departamentos.length < 2) {
            throw new ValidacaoEquipeException("Um Diretor deve dirigir no mínimo 2 departamentos.");
        }
        this.departamentos = departamentos;
    }

    // Bônus: 4x salário + R$3000 por departamento
    @Override
    public double getBonus() {
        double bonusBase = getSalario() * 4.0;
        double bonusDepartamentos = departamentos.length * 3000.0;
        return bonusBase + bonusDepartamentos;
    }
}
