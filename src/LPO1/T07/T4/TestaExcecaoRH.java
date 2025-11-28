package LPO1.T07.T4;

// Testes de regras de equipe com exceções verificadas
public class TestaExcecaoRH {

    public static void main(String[] args) {

        // Dados de apoio
        Funcionario p1 = new Programador("Pedro", "111", 5000);
        Funcionario p2 = new Analista("Ana", "222", 7000);
        Funcionario p3 = new AuxiliarLimpeza("Mário", "333", 1500);
        Funcionario p4 = new Programador("Zeca", "444", 5000);
        Funcionario p5 = new Analista("Bia", "555", 7000);

        Departamento d1 = new Departamento("Vendas");
        Departamento d2 = new Departamento("TI");

        // Gerente com equipe insuficiente (espera erro)
        System.out.println("Teste 1: Criar Gerente com equipe pequena (3 pessoas)");
        Funcionario[] equipePequena = { p1, p2, p3 };
        try {
            Gerente g1 = new Gerente("Carla", "666", 10000, equipePequena);
            System.out.println("ERRO NO TESTE: Gerente foi criado (não deveria).");
        } catch (ValidacaoEquipeException e) {
            System.out.println("Capturamos o erro esperado:");
            System.out.println("   " + e.getMessage());
        }

        // Gerente com equipe mínima válida
        System.out.println("\nTeste 2: Criar Gerente com equipe OK (5 pessoas)");
        Funcionario[] equipeGrande = { p1, p2, p3, p4, p5 };
        try {
            Gerente g2 = new Gerente("Marcos", "777", 10000, equipeGrande);
            System.out.println("Sucesso! Gerente " + g2.getNome() + " criado.");
        } catch (ValidacaoEquipeException e) {
            System.out.println("ERRO NO TESTE: Falhou, mas deveria ter funcionado.");
        }

        // Diretor com departamentos insuficientes (espera erro)
        System.out.println("\nTeste 3: Criar Diretor com 1 depto");
        Departamento[] deptoPequeno = { d1 };
        try {
            Diretor d1Inv = new Diretor("Roberto", "888", 20000, deptoPequeno);
            System.out.println("ERRO NO TESTE: Diretor foi criado (não deveria).");
        } catch (ValidacaoEquipeException e) {
            System.out.println("Capturamos o erro esperado:");
            System.out.println("   " + e.getMessage());
        }

        // Diretor com quantidade mínima válida
        System.out.println("\nTeste 4: Criar Diretor com 2 deptos");
        Departamento[] deptoOK = { d1, d2 };
        try {
            Diretor d2Ok = new Diretor("Julia", "999", 20000, deptoOK);
            System.out.println("Sucesso! Diretor " + d2Ok.getNome() + " criado.");
        } catch (ValidacaoEquipeException e) {
            System.out.println("ERRO NO TESTE: Falhou, mas deveria ter funcionado.");
        }
    }
}

