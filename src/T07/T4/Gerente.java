package T07.T4;

// Exige equipe mínima e sinaliza violação com exceção verificada
public class Gerente extends Funcionario {

    private Funcionario[] funcionariosGerenciados;

    // Construtor valida a equipe via setter para manter regra em um único ponto
    public Gerente(String nome, String cpf, double salario, Funcionario[] gerenciados)
            throws ValidacaoEquipeException {
        super(nome, cpf, salario);
        setFuncionariosGerenciados(gerenciados);
    }

    // Regra de negócio: equipe mínima de 5
    public void setFuncionariosGerenciados(Funcionario[] gerenciados)
            throws ValidacaoEquipeException {
        if (gerenciados == null || gerenciados.length < 5) {
            throw new ValidacaoEquipeException("Um Gerente deve gerenciar no mínimo 5 pessoas.");
        }
        this.funcionariosGerenciados = gerenciados;
    }

    // Bônus: 2x salário + R$100 por pessoa na equipe
    @Override
    public double getBonus() {
        double bonusBase = getSalario() * 2.0;
        double bonusEquipe = funcionariosGerenciados.length * 100.0;
        return bonusBase + bonusEquipe;
    }
}

