package T06.T2;

import java.util.Scanner;

public class SistemaAcademico {

    // Listas e contadores
    private static Aluno[] listaDeAlunos;
    private static Professor[] listaDeProfessores;
    private static Disciplina[] listaDeDisciplinas;
    private static int numAlunosCadastrados = 0;
    private static int numProfessoresCadastrados = 0;
    private static int numDisciplinasCadastradas = 0;

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Capacidade das listas
        System.out.print("Informe a quantidade total de Alunos: ");
        listaDeAlunos = new Aluno[lerIntPositivo()];
        System.out.print("Informe a quantidade total de Professores: ");
        listaDeProfessores = new Professor[lerIntPositivo()];
        System.out.print("Informe a quantidade total de Disciplinas: ");
        listaDeDisciplinas = new Disciplina[lerIntPositivo()];

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- SISTEMA ACADÊMICO (v2.0 com Herança) ---");
            System.out.println("1 – Cadastrar Aluno");
            System.out.println("2 – Cadastrar Professor");
            System.out.println("3 – Cadastrar Disciplina");
            System.out.println("4 – Associar Professor a Disciplina");
            System.out.println("5 – Matricular Aluno em Disciplina");
            System.out.println("6 – Cancelar Matrícula de Aluno");
            System.out.println("7 – Imprimir Relatório de Aluno");
            System.out.println("8 – Sair");
            System.out.print("Opção: ");

            int opcao = lerIntPositivo();

            switch (opcao) {
                case 1 -> chamarCadastroAluno();
                case 2 -> chamarCadastroProfessor();
                case 3 -> chamarCadastroDisciplina();
                case 4 -> chamarAssociarProfessorDisciplina();
                case 5 -> chamarMatricularAluno();
                case 6 -> chamarCancelarMatricula();
                case 7 -> chamarImprimirRelatorio();
                case 8 -> {
                    executando = false;
                    System.out.println("Encerrando sistema...");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    // Cadastro de Aluno
    private static void chamarCadastroAluno() {
        if (numAlunosCadastrados >= listaDeAlunos.length) {
            System.out.println("Erro: Limite de alunos atingido.");
            return;
        }
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine().trim();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();
        System.out.print("Curso: ");
        String curso = sc.nextLine().trim();
        System.out.print("Período: ");
        int periodo = lerIntPositivo();
        System.out.print("Limite de disciplinas do aluno: ");
        int maxDisciplinas = lerIntPositivo();

        Aluno novoAluno = new Aluno(nome, cpf, endereco, matricula, curso, periodo, maxDisciplinas);
        listaDeAlunos[numAlunosCadastrados++] = novoAluno;
        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Cadastro de Professor
    private static void chamarCadastroProfessor() {
        if (numProfessoresCadastrados >= listaDeProfessores.length) {
            System.out.println("Erro: Limite de professores atingido.");
            return;
        }
        System.out.print("Nome do professor: ");
        String nome = sc.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine().trim();
        System.out.print("Departamento: ");
        String depto = sc.nextLine().trim();
        System.out.print("Salário: ");
        double salario = lerDouble();
        System.out.print("Limite de disciplinas do professor: ");
        int maxDisciplinas = lerIntPositivo();

        Professor novoProfessor = new Professor(nome, cpf, endereco, depto, salario, maxDisciplinas);
        listaDeProfessores[numProfessoresCadastrados++] = novoProfessor;
        System.out.println("Professor cadastrado com sucesso!");
    }

    // Cadastro de Disciplina
    private static void chamarCadastroDisciplina() {
        if (numDisciplinasCadastradas >= listaDeDisciplinas.length) {
            System.out.println("Erro: Limite de disciplinas atingido.");
            return;
        }
        System.out.print("Nome da disciplina: ");
        String nome = sc.nextLine().trim();
        System.out.print("Código da disciplina (ex: MAT01): ");
        String codigo = sc.nextLine().trim();
        System.out.print("Máximo de alunos na disciplina: ");
        int maxAlunos = lerIntPositivo();

        Disciplina novaDisciplina = new Disciplina(nome, codigo, maxAlunos);
        listaDeDisciplinas[numDisciplinasCadastradas++] = novaDisciplina;
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    // Associação Professor -> Disciplina
    private static void chamarAssociarProfessorDisciplina() {
        System.out.print("Nome do Professor: ");
        Professor prof = encontrarProfessorPorNome(sc.nextLine());
        if (prof == null) {
            System.out.println("Erro: Professor não encontrado.");
            return;
        }
        System.out.print("Nome da Disciplina: ");
        Disciplina disc = encontrarDisciplinaPorNome(sc.nextLine());
        if (disc == null) {
            System.out.println("Erro: Disciplina não encontrada.");
            return;
        }
        String resultado = prof.adicionaDisciplina(disc);
        System.out.println(resultado);
    }

    // Matrícula Aluno -> Disciplina
    private static void chamarMatricularAluno() {
        System.out.print("Nome do Aluno: ");
        Aluno aluno = encontrarAlunoPorNome(sc.nextLine());
        if (aluno == null) {
            System.out.println("Erro: Aluno não encontrado.");
            return;
        }
        System.out.print("Nome da Disciplina: ");
        Disciplina disc = encontrarDisciplinaPorNome(sc.nextLine());
        if (disc == null) {
            System.out.println("Erro: Disciplina não encontrada.");
            return;
        }
        String resultado = aluno.fazMatricula(disc);
        System.out.println(resultado);
    }

    // Cancelar Matrícula
    private static void chamarCancelarMatricula() {
        System.out.print("Nome do Aluno: ");
        Aluno aluno = encontrarAlunoPorNome(sc.nextLine());
        if (aluno == null) {
            System.out.println("Erro: Aluno não encontrado.");
            return;
        }
        System.out.print("Nome da Disciplina a cancelar: ");
        String nomeDisciplina = sc.nextLine();
        String resultado = aluno.cancelarMatricula(nomeDisciplina);
        System.out.println(resultado);
    }

    // Relatório de Aluno
    private static void chamarImprimirRelatorio() {
        System.out.print("Nome do Aluno: ");
        Aluno aluno = encontrarAlunoPorNome(sc.nextLine());
        if (aluno == null) {
            System.out.println("Erro: Aluno não encontrado.");
            return;
        }
        System.out.println(aluno.imprime());
    }

    // Buscas por nome (case-insensitive)
    private static Aluno encontrarAlunoPorNome(String nome) {
        String alvo = nome == null ? "" : nome.trim();
        for (int i = 0; i < numAlunosCadastrados; i++) {
            if (listaDeAlunos[i].getNome().equalsIgnoreCase(alvo)) {
                return listaDeAlunos[i];
            }
        }
        return null;
    }

    private static Professor encontrarProfessorPorNome(String nome) {
        String alvo = nome == null ? "" : nome.trim();
        for (int i = 0; i < numProfessoresCadastrados; i++) {
            if (listaDeProfessores[i].getNome().equalsIgnoreCase(alvo)) {
                return listaDeProfessores[i];
            }
        }
        return null;
    }

    private static Disciplina encontrarDisciplinaPorNome(String nome) {
        String alvo = nome == null ? "" : nome.trim();
        for (int i = 0; i < numDisciplinasCadastradas; i++) {
            if (listaDeDisciplinas[i].getNome().equalsIgnoreCase(alvo)) {
                return listaDeDisciplinas[i];
            }
        }
        return null;
    }

    // Leitura segura
    private static int lerIntPositivo() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v > 0) return v;
                System.out.print("Informe um inteiro positivo: ");
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Tente novamente: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Tente novamente: ");
            }
        }
    }
}

