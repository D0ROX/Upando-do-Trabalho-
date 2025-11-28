package LPO1.T08.T3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// GUI simples para cadastro e relações acadêmicas
public class SistemaAcademicoGUI extends JFrame implements ActionListener {

    // Estado em memória (listas dinâmicas)
    private final List<Aluno> listaDeAlunos = new ArrayList<>();
    private final List<Professor> listaDeProfessores = new ArrayList<>();
    private final List<Disciplina> listaDeDisciplinas = new ArrayList<>();

    // Componentes
    private JTextArea txtLog;
    private JButton btnCadastrarAluno;
    private JButton btnCadastrarProfessor;
    private JButton btnCadastrarDisciplina;
    private JButton btnAssociarProfDisc;
    private JButton btnMatricularAluno;
    private JButton btnCancelarMatricula;
    private JButton btnImprimirRelatorio;

    public SistemaAcademicoGUI() {
        setTitle("Sistema Acadêmico (GUI)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel painelBotoes = new JPanel(new GridLayout(7, 1, 5, 5));
        btnCadastrarAluno = new JButton("1. Cadastrar Aluno");
        btnCadastrarProfessor = new JButton("2. Cadastrar Professor");
        btnCadastrarDisciplina = new JButton("3. Cadastrar Disciplina");
        btnAssociarProfDisc = new JButton("4. Associar Professor");
        btnMatricularAluno = new JButton("5. Matricular Aluno");
        btnCancelarMatricula = new JButton("6. Cancelar Matrícula");
        btnImprimirRelatorio = new JButton("7. Imprimir Relatório Aluno");

        painelBotoes.add(btnCadastrarAluno);
        painelBotoes.add(btnCadastrarProfessor);
        painelBotoes.add(btnCadastrarDisciplina);
        painelBotoes.add(btnAssociarProfDisc);
        painelBotoes.add(btnMatricularAluno);
        painelBotoes.add(btnCancelarMatricula);
        painelBotoes.add(btnImprimirRelatorio);

        txtLog = new JTextArea("Bem-vindo ao Sistema Acadêmico!\n");
        txtLog.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(txtLog);

        add(painelBotoes, BorderLayout.WEST);
        add(scrollLog, BorderLayout.CENTER);

        // Um único listener trata todos os botões (simples e direto)
        btnCadastrarAluno.addActionListener(this);
        btnCadastrarProfessor.addActionListener(this);
        btnCadastrarDisciplina.addActionListener(this);
        btnAssociarProfDisc.addActionListener(this);
        btnMatricularAluno.addActionListener(this);
        btnCancelarMatricula.addActionListener(this);
        btnImprimirRelatorio.addActionListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaAcademicoGUI janela = new SistemaAcademicoGUI();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fonte = e.getSource();
        try {
            if (fonte == btnCadastrarAluno) {
                chamarCadastroAluno();
            } else if (fonte == btnCadastrarProfessor) {
                chamarCadastroProfessor();
            } else if (fonte == btnCadastrarDisciplina) {
                chamarCadastroDisciplina();
            } else if (fonte == btnAssociarProfDisc) {
                chamarAssociarProfessorDisciplina();
            } else if (fonte == btnMatricularAluno) {
                chamarMatricularAluno();
            } else if (fonte == btnCancelarMatricula) {
                chamarCancelarMatricula();
            } else if (fonte == btnImprimirRelatorio) {
                chamarImprimirRelatorio();
            }
        } catch (Exception ex) {
            log("Erro: " + ex.getMessage());
        }
    }

    // Log simples
    private void log(String mensagem) {
        txtLog.append(mensagem + "\n");
    }

    // Cadastro de Aluno (com validação de números)
    private void chamarCadastroAluno() {
        String nome = input("Nome do Aluno:");
        if (nome == null) return;
        String cpf = input("CPF:");
        String endereco = input("Endereço:");
        String matricula = input("Matrícula:");
        String curso = input("Curso:");
        Integer periodo = inputInt("Período:");
        if (periodo == null) return;
        Integer maxDisciplinas = inputInt("Limite de Disciplinas:");
        if (maxDisciplinas == null) return;

        Aluno novoAluno = new Aluno(nome, cpf, endereco, matricula, curso, periodo, maxDisciplinas);
        listaDeAlunos.add(novoAluno);
        log("Aluno " + nome + " cadastrado com sucesso!");
    }

    // Cadastro de Professor
    private void chamarCadastroProfessor() {
        String nome = input("Nome do Professor:");
        if (nome == null) return;
        String cpf = input("CPF:");
        String endereco = input("Endereço:");
        String depto = input("Departamento:");
        Double salario = inputDouble("Salário:");
        if (salario == null) return;
        Integer maxDisciplinas = inputInt("Limite de Disciplinas:");
        if (maxDisciplinas == null) return;

        Professor novoProfessor = new Professor(nome, cpf, endereco, depto, salario, maxDisciplinas);
        listaDeProfessores.add(novoProfessor);
        log("Professor " + nome + " cadastrado com sucesso!");
    }

    // Cadastro de Disciplina
    private void chamarCadastroDisciplina() {
        String nome = input("Nome da Disciplina:");
        if (nome == null) return;
        String codigo = input("Código da Disciplina:");
        Integer maxAlunos = inputInt("Máximo de Alunos:");
        if (maxAlunos == null) return;

        Disciplina novaDisciplina = new Disciplina(nome, codigo, maxAlunos);
        listaDeDisciplinas.add(novaDisciplina);
        log("Disciplina " + nome + " cadastrada com sucesso!");
    }

    // Associa professor à disciplina
    private void chamarAssociarProfessorDisciplina() {
        String nomeProf = input("Nome do Professor:");
        Professor prof = encontrarProfessorPorNome(nomeProf);
        if (prof == null) { log("Erro: Professor " + nomeProf + " não encontrado."); return; }

        String nomeDisc = input("Nome da Disciplina:");
        Disciplina disc = encontrarDisciplinaPorNome(nomeDisc);
        if (disc == null) { log("Erro: Disciplina " + nomeDisc + " não encontrada."); return; }

        log(prof.adicionaDisciplina(disc));
    }

    // Matricula aluno em disciplina
    private void chamarMatricularAluno() {
        String nomeAluno = input("Nome do Aluno:");
        Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        if (aluno == null) { log("Erro: Aluno " + nomeAluno + " não encontrado."); return; }

        String nomeDisc = input("Nome da Disciplina:");
        Disciplina disc = encontrarDisciplinaPorNome(nomeDisc);
        if (disc == null) { log("Erro: Disciplina " + nomeDisc + " não encontrada."); return; }

        log(aluno.fazMatricula(disc));
    }

    // Cancela matrícula do aluno
    private void chamarCancelarMatricula() {
        String nomeAluno = input("Nome do Aluno:");
        Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        if (aluno == null) { log("Erro: Aluno " + nomeAluno + " não encontrado."); return; }

        String nomeDisc = input("Nome da Disciplina a cancelar:");
        log(aluno.cancelarMatricula(nomeDisc));
    }

    // Imprime relatório do aluno
    private void chamarImprimirRelatorio() {
        String nomeAluno = input("Nome do Aluno para Relatório:");
        Aluno aluno = encontrarAlunoPorNome(nomeAluno);
        if (aluno == null) { log("Erro: Aluno " + nomeAluno + " não encontrado."); return; }
        log(aluno.imprime());
    }

    // Inputs com tratamento
    private String input(String msg) {
        return JOptionPane.showInputDialog(this, msg);
    }
    private Integer inputInt(String msg) {
        String s = input(msg);
        if (s == null) return null;
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) { log("Entrada inválida (inteiro): " + s); return null; }
    }
    private Double inputDouble(String msg) {
        String s = input(msg);
        if (s == null) return null;
        try { return Double.parseDouble(s.trim().replace(",", ".")); }
        catch (NumberFormatException e) { log("Entrada inválida (decimal): " + s); return null; }
    }

    // Buscas simples por nome
    private Aluno encontrarAlunoPorNome(String nome) {
        for (Aluno a : listaDeAlunos) if (a.getNome().equalsIgnoreCase(nome)) return a;
        return null;
    }
    private Professor encontrarProfessorPorNome(String nome) {
        for (Professor p : listaDeProfessores) if (p.getNome().equalsIgnoreCase(nome)) return p;
        return null;
    }
    private Disciplina encontrarDisciplinaPorNome(String nome) {
        for (Disciplina d : listaDeDisciplinas) if (d.getNome().equalsIgnoreCase(nome)) return d;
        return null;
    }
}

