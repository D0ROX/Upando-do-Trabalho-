package T06.T1;

// Gerente herda de Funcionario
public class Gerente extends Funcionario {

    // Equipe gerenciada
    private Funcionario[] funcionariosGerenciados;

    public Gerente(String nome, String cpf, double salario, Funcionario[] gerenciados) {
        super(nome, cpf, salario);
        // cópia defensiva (evita alterações externas)
        this.funcionariosGerenciados = gerenciados == null ? new Funcionario[0]
                : java.util.Arrays.copyOf(gerenciados, gerenciados.length);
    }

    // Bônus: 2x salário + R$100 por pessoa
    @Override
    public double getBonus() {
        double bonusBase = getSalario() * 2.0;
        double bonusEquipe = funcionariosGerenciados.length * 100.0;
        return bonusBase + bonusEquipe;
    }

    // acesso somente leitura (cópia defensiva)
    public Funcionario[] getFuncionariosGerenciados() {
        return java.util.Arrays.copyOf(funcionariosGerenciados, funcionariosGerenciados.length);
    }
}

