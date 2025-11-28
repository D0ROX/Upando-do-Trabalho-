package LPO1.T05.T1;

import java.util.Scanner;

public class SistemaAcademico {

    // (d) Lista (array) para guardar todos os alunos
    private static Aluno[] listaDeAlunos;
    // Conta quantos alunos estão na lista
    private static int numAlunosCadastrados = 0;

    // Scanner para ler o teclado (estático para ser usado por todos)
    private static Scanner sc = new Scanner(System.in);

    // Método principal. Controla o menu.
    public static void main(String[] args) {

        // (e) Pergunta o tamanho da lista e a inicializa
        System.out.print("Informe a quantidade total de alunos que serão cadastrados: ");
        int totalAlunos = Integer.parseInt(sc.nextLine());
        listaDeAlunos = new Aluno[totalAlunos];

        boolean executando = true;

        // Loop principal do menu
        while (executando) {
            System.out.println("\nMENU DO SISTEMA ACADÊMICO: ");
            System.out.println("1 – Cadastrar Aluno");
            System.out.println("2 – Excluir aluno por nome");
            System.out.println("3 – Listar Alunos (simples)");
            System.out.println("4 – Matricular Aluno em Disciplina");
            System.out.println("5 – Cancelar Matrícula de Aluno");
            System.out.println("6 – Imprimir lista Alunos e Disciplinas");
            System.out.println("7 – Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(sc.nextLine());

            // Chama o método certo para a opção escolhida
            switch (opcao) {
                case 1:
                    chamarCadastroAluno();
                    break;
                case 2:
                    chamarExcluirAluno();
                    break;
                case 3:
                    chamarListarAlunos();
                    break;
                case 4:
                    chamarMatricularAluno();
                    break;
                case 5:
                    chamarCancelarMatricula();
                    break;
                case 6:
                    chamarImprimirListaCompleta();
                    break;
                case 7:
                    executando = false;
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        sc.close();
    }

    // Pede os dados para criar um aluno
    private static void chamarCadastroAluno() {
        // Verifica se a lista principal está cheia
        if (numAlunosCadastrados >= listaDeAlunos.length) {
            System.out.println("Erro: Limite de alunos cadastrados atingido.");
            return;
        }

        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Curso: ");
        String curso = sc.nextLine();
        System.out.print("Período: ");
        int periodo = Integer.parseInt(sc.nextLine());
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        // (f) Pergunta o limite de disciplinas do aluno
        System.out.print("Quantas disciplinas este aluno pode se matricular? ");
        int quantDisciplinas = Integer.parseInt(sc.nextLine());

        // Cria o objeto Aluno
        Aluno novoAluno = new Aluno(nome, matricula, curso, periodo, quantDisciplinas);
        novoAluno.setEndereco(endereco); // Define o endereço

        // Chama o método (d.1) para salvar na lista
        cadastrarAluno(novoAluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    // Pede o nome para a exclusão
    private static void chamarExcluirAluno() {
        System.out.print("Digite o nome do aluno a excluir: ");
        String nome = sc.nextLine();
        // Chama o método estático (d.2)
        excluirAlunoPorNome(nome);
    }

    // Mostra uma lista simples (nome/matrícula)
    private static void chamarListarAlunos() {
        System.out.println("\n--- Lista de Alunos Cadastrados ---");
        // Chama o método estático (d.3)
        Aluno[] alunos = listarAlunos();

        if (numAlunosCadastrados == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (int i = 0; i < numAlunosCadastrados; i++) {
            System.out.println("- " + alunos[i].getNome() + " (Mat: " + alunos[i].getMatricula() + ")");
        }
    }

    // Pede o aluno e a disciplina para a matrícula
    private static void chamarMatricularAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();

        // Procura o aluno na lista principal
        Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        if (aluno == null) {
            System.out.println("Erro: Aluno não encontrado.");
            return;
        }

        System.out.print("Digite o nome da disciplina a matricular: ");
        String disciplina = sc.nextLine();

        // Chama o método estático (d.4)
        String resultado = matricularAlunoEmDisciplina(aluno, disciplina);
        System.out.println(resultado); // Imprime o resultado (sucesso ou erro)
    }

    // Pede o aluno e a disciplina para o cancelamento
    private static void chamarCancelarMatricula() {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = sc.nextLine();

        Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        if (aluno == null) {
            System.out.println("Erro: Aluno não encontrado.");
            return;
        }

        System.out.print("Digite o nome da disciplina a cancelar: ");
        String disciplina = sc.nextLine();

        // Chama o método estático (d.5)
        String resultado = cancelarMatricula(aluno, disciplina);
        System.out.println(resultado); // Imprime o resultado (sucesso ou erro)
    }

    // Imprime o relatório completo
    private static void chamarImprimirListaCompleta() {
        // Chama o método estático (d.6)
        String listaCompleta = imprimirListaDeAlunoseDisciplinas();
        System.out.println(listaCompleta);
    }

    // (d.1) Adiciona o aluno na lista principal
    public static void cadastrarAluno(Aluno aluno) {
        if (numAlunosCadastrados < listaDeAlunos.length) {
            listaDeAlunos[numAlunosCadastrados] = aluno;
            numAlunosCadastrados++;
        }
    }

    // (d.2) Exclui um aluno da lista pelo nome
    public static void excluirAlunoPorNome(String nomeAluno) {
        int indiceEncontrado = -1;

        for (int i = 0; i < numAlunosCadastrados; i++) {
            if (listaDeAlunos[i].getNome().equalsIgnoreCase(nomeAluno)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("Erro: Aluno não encontrado para exclusão.");
            return;
        }

        // "Puxa" os alunos para frente para cobrir o espaço
        for (int i = indiceEncontrado; i < numAlunosCadastrados - 1; i++) {
            listaDeAlunos[i] = listaDeAlunos[i + 1];
        }

        listaDeAlunos[numAlunosCadastrados - 1] = null; // Limpa a última posição
        numAlunosCadastrados--;

        System.out.println("Aluno " + nomeAluno + " excluído com sucesso.");
    }

    // (d.3) Retorna a lista principal de alunos
    public static Aluno[] listarAlunos() {
        return listaDeAlunos;
    }

    // (d.4) Apenas repassa a chamada para o objeto Aluno
    public static String matricularAlunoEmDisciplina(Aluno aluno, String disciplina) {
        return aluno.fazMatricula(disciplina);
    }

    // (d.5) Apenas repassa a chamada para o objeto Aluno
    public static String cancelarMatricula(Aluno aluno, String disciplina) {
        return aluno.cancelarMatricula(disciplina);
    }

    // (d.6) Monta uma string com os dados de TODOS os alunos
    public static String imprimirListaDeAlunoseDisciplinas() {
        if (numAlunosCadastrados == 0) {
            return "Nenhum aluno cadastrado para imprimir.";
        }

        // StringBuilder é bom para montar strings grandes
        StringBuilder sb = new StringBuilder();

        sb.append("\n--- LISTA COMPLETA DE ALUNOS E DISCIPLINAS ---\n");
        for (int i = 0; i < numAlunosCadastrados; i++) {
            sb.append(listaDeAlunos[i].imprime());
            sb.append("\n"); // Adiciona um espaço
        }
        return sb.toString();
    }

    // Método auxiliar para achar um aluno na lista pelo nome
    private static Aluno encontrarAlunoPorNome(String nome) {
        for (int i = 0; i < numAlunosCadastrados; i++) {
            if (listaDeAlunos[i].getNome().equalsIgnoreCase(nome)) {
                return listaDeAlunos[i];
            }
        }
        return null; // Retorna null se não encontrar
    }
}
