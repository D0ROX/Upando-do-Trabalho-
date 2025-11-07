package T06.T1;

// Diretor herda de Funcionario
public class Diretor extends Funcionario {

    // Departamentos sob gestão
    private Departamento[] departamentos;

    public Diretor(String nome, String cpf, double salario, Departamento[] departamentos) {
        super(nome, cpf, salario);
        // cópia defensiva
        this.departamentos = departamentos == null ? new Departamento[0]
                : java.util.Arrays.copyOf(departamentos, departamentos.length);
    }

    // Bônus: 4x salário + R$3000 por departamento
    @Override
    public double getBonus() {
        double bonusBase = getSalario() * 4.0;
        double bonusDepartamentos = departamentos.length * 3000.0;
        return bonusBase + bonusDepartamentos;
    }

    // acesso somente leitura (cópia defensiva)
    public Departamento[] getDepartamentos() {
        return java.util.Arrays.copyOf(departamentos, departamentos.length);
    }
}

