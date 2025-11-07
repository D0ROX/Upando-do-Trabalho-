package T06.T1;

public class SistemaRH {

    public static void main(String[] args) {
        // Objetos base
        Departamento deptoVendas = new Departamento("Vendas");
        Departamento deptoTI = new Departamento("TI");
        Departamento[] departamentosDiretor = { deptoVendas, deptoTI };

        Programador p1 = new Programador("Pedro", "111.111.111-11", 5000.0);
        Analista a1 = new Analista("Ana", "222.222.222-22", 7000.0);
        AuxiliarLimpeza l1 = new AuxiliarLimpeza("Mário", "333.333.333-33", 1500.0);

        Funcionario[] equipeGerente = { p1, a1 };

        // Lideranças
        Gerente g1 = new Gerente("Carla", "444.444.444-44", 10000.0, equipeGerente);
        Diretor d1 = new Diretor("Roberto", "555.555.555-55", 20000.0, departamentosDiretor);

        // Lista principal (polimorfismo)
        Funcionario[] listaFuncionarios = { p1, a1, l1, g1, d1 };

        // Relatório
        imprimeRelatorio(listaFuncionarios);
    }

    // Imprime relatório de bônus
    public static void imprimeRelatorio(Funcionario[] listaFuncionarios) {

        System.out.println("RELATÓRIO DE BÔNUS ANUAL - EMPRESA X: \n");

        for (Funcionario f : listaFuncionarios) {
            System.out.printf("Nome: %s%n", f.getNome());
            System.out.printf("Salário: R$ %.2f%n", f.getSalario());
            // Polimorfismo: chama o getBonus da classe concreta
            System.out.printf("Bônus: R$ %.2f%n", f.getBonus());
            System.out.println("----------------------------------------------");
        }
    }
}
