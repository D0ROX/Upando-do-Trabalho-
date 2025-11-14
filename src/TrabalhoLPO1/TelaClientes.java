package TrabalhoLPO1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaClientes extends JFrame {
    private final GerenciadorBanco banco;
    private JTable tabela;
    private ModeloTabelaCliente modelo;
    private JTextField txtNome, txtSobrenome, txtRg, txtCpf, txtEndereco;
    private JTextField txtBusca;
    private JComboBox<String> cbTipoBusca, cbOrdenacao;

    // Botões de ação (para não limpar seleção ao clicar)
    private JButton btnAdicionar, btnAtualizar, btnExcluir, btnLimpar;
    private JButton btnBuscar, btnMostrarTodos, btnOrdenar;

    // Guardar referência do listener global para remover no dispose, se quiser
    private java.awt.event.AWTEventListener listenerGlobal;

    public TelaClientes(GerenciadorBanco banco) {
        this.banco = banco;

        setTitle("Gerenciar Clientes");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel painelFormulario = criarPainelFormulario();
        JPanel painelTabela = criarPainelTabela();
        JPanel painelBusca = criarPainelBusca();

        painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        painelPrincipal.add(painelBusca, BorderLayout.SOUTH);

        setContentPane(painelPrincipal);

        // Listener global de mouse: limpa seleção ao clicar fora da JTable e fora de botões
        listenerGlobal = evento -> {
            if (!(evento instanceof java.awt.event.MouseEvent)) return;
            java.awt.event.MouseEvent me = (java.awt.event.MouseEvent) evento;
            if (me.getID() != java.awt.event.MouseEvent.MOUSE_PRESSED) return;

            // Verifica se o evento pertence a esta janela
            Window janelaDoEvento = SwingUtilities.getWindowAncestor((Component) me.getSource());
            if (janelaDoEvento != this) return;

            Component origem = (Component) me.getSource();

            // Não limpa se clicar dentro da JTable
            if (SwingUtilities.isDescendingFrom(origem, tabela)) return;

            // Não limpa se clicar em JButton (ou dentro dele)
            if (origem instanceof JButton) return;
            Component atual = origem;
            while (atual != null) {
                if (atual instanceof JButton) return;
                atual = atual.getParent();
            }

            limparSelecaoTabela();
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(listenerGlobal, AWTEvent.MOUSE_EVENT_MASK);

        // Listeners adicionais nos campos (clicar/focar) para garantir UX
        registrarLimpaSelecaoEmComponentes(painelFormulario, painelBusca);
    }

    @Override
    public void dispose() {
        // Remove o listener global ao fechar a tela (boa prática)
        if (listenerGlobal != null) {
            Toolkit.getDefaultToolkit().removeAWTEventListener(listenerGlobal);
            listenerGlobal = null;
        }
        super.dispose();
    }

    private JPanel criarPainelFormulario() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        txtNome = new JTextField(15);
        txtSobrenome = new JTextField(15);
        txtRg = new JTextField(15);
        txtCpf = new JTextField(15);
        txtEndereco = new JTextField(30);

        gbc.gridx = 0; gbc.gridy = 0;
        painel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        painel.add(txtNome, gbc);

        gbc.gridx = 2;
        painel.add(new JLabel("Sobrenome:"), gbc);
        gbc.gridx = 3;
        painel.add(txtSobrenome, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        painel.add(new JLabel("RG:"), gbc);
        gbc.gridx = 1;
        painel.add(txtRg, gbc);

        gbc.gridx = 2;
        painel.add(new JLabel("CPF:"), gbc);
        gbc.gridx = 3;
        painel.add(txtCpf, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        painel.add(new JLabel("Endereço:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        painel.add(txtEndereco, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> adicionarCliente());
        painel.add(btnAdicionar, gbc);

        gbc.gridx = 1;
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> atualizarCliente());
        painel.add(btnAtualizar, gbc);

        gbc.gridx = 2;
        btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> excluirCliente());
        painel.add(btnExcluir, gbc);

        gbc.gridx = 3;
        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());
        painel.add(btnLimpar, gbc);

        return painel;
    }

    private JPanel criarPainelTabela() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));

        modelo = new ModeloTabelaCliente(banco.getClientes());
        tabela = new JTable(modelo);

        // Seleção múltipla
        tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Preencher o formulário somente quando houver 1 linha selecionada
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int[] linhas = tabela.getSelectedRows();
                if (linhas != null && linhas.length == 1) {
                    preencherFormulario(linhas[0]);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabela);
        painel.add(scrollPane, BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelBusca() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.setBorder(BorderFactory.createTitledBorder("Busca e Ordenação"));

        painel.add(new JLabel("Buscar por:"));
        cbTipoBusca = new JComboBox<>(new String[]{"Nome", "Sobrenome", "RG", "CPF"});
        painel.add(cbTipoBusca);

        txtBusca = new JTextField(20);
        painel.add(txtBusca);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarClientes());
        painel.add(btnBuscar);

        btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.addActionListener(e -> atualizarTabela(banco.getClientes()));
        painel.add(btnMostrarTodos);

        painel.add(new JLabel(" | Ordenar por:"));
        cbOrdenacao = new JComboBox<>(new String[]{"Nome", "Sobrenome"});
        painel.add(cbOrdenacao);

        btnOrdenar = new JButton("Ordenar");
        btnOrdenar.addActionListener(e -> ordenarClientes());
        painel.add(btnOrdenar);

        return painel;
    }

    private void registrarLimpaSelecaoEmComponentes(JPanel painelFormulario, JPanel painelBusca) {
        java.awt.event.MouseAdapter limpaAoClicar = new java.awt.event.MouseAdapter() {
            @Override public void mousePressed(java.awt.event.MouseEvent e) {
                Component origem = (Component) e.getSource();
                // Não limpar se clique for em botão (ou dentro dele)
                if (origem instanceof JButton) return;
                Component atual = origem;
                while (atual != null) {
                    if (atual instanceof JButton) return;
                    atual = atual.getParent();
                }
                // Se não é clique dentro da JTable, limpa
                if (!SwingUtilities.isDescendingFrom(origem, tabela)) {
                    limparSelecaoTabela();
                }
            }
        };
        java.awt.event.FocusAdapter limpaAoFocar = new java.awt.event.FocusAdapter() {
            @Override public void focusGained(java.awt.event.FocusEvent e) {
                Component origem = (Component) e.getSource();
                if (!SwingUtilities.isDescendingFrom(origem, tabela)) {
                    limparSelecaoTabela();
                }
            }
        };

        // Formulário
        txtNome.addMouseListener(limpaAoClicar);      txtNome.addFocusListener(limpaAoFocar);
        txtSobrenome.addMouseListener(limpaAoClicar); txtSobrenome.addFocusListener(limpaAoFocar);
        txtRg.addMouseListener(limpaAoClicar);        txtRg.addFocusListener(limpaAoFocar);
        txtCpf.addMouseListener(limpaAoClicar);       txtCpf.addFocusListener(limpaAoFocar);
        txtEndereco.addMouseListener(limpaAoClicar);  txtEndereco.addFocusListener(limpaAoFocar);

        // Busca/Ordenação
        txtBusca.addMouseListener(limpaAoClicar);     txtBusca.addFocusListener(limpaAoFocar);
        cbTipoBusca.addMouseListener(limpaAoClicar);  cbTipoBusca.addFocusListener(limpaAoFocar);
        cbOrdenacao.addMouseListener(limpaAoClicar);  cbOrdenacao.addFocusListener(limpaAoFocar);

        // Também adicionar nos próprios painéis para pegar cliques no "fundo"
        painelFormulario.addMouseListener(limpaAoClicar);
        painelBusca.addMouseListener(limpaAoClicar);
    }

    private void limparSelecaoTabela() {
        if (tabela != null) {
            tabela.clearSelection();
        }
        // Opcional: limpar também o formulário
        // limparCampos();
    }

    private void adicionarCliente() {
        if (!validarCampos()) return;

        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        String rg = txtRg.getText();
        String cpf = txtCpf.getText();
        String endereco = txtEndereco.getText();

        if (banco.existeNomeSobrenome(nome, sobrenome)) {
            JOptionPane.showMessageDialog(this, "Já existe cliente com o mesmo Nome e Sobrenome.");
            return;
        }
        if (banco.existeRg(rg)) {
            JOptionPane.showMessageDialog(this, "Já existe cliente com o mesmo RG.");
            return;
        }
        if (banco.existeCpf(cpf)) {
            JOptionPane.showMessageDialog(this, "Já existe cliente com o mesmo CPF.");
            return;
        }

        Cliente cliente = new Cliente(nome, sobrenome, rg, cpf, endereco);
        banco.adicionarCliente(cliente);
        atualizarTabela(banco.getClientes());
        limparCampos();
        JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
    }

    private void atualizarCliente() {
        int[] linhas = tabela.getSelectedRows();
        if (linhas == null || linhas.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para atualizar!");
            return;
        }
        if (linhas.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecione apenas um cliente para atualizar!");
            return;
        }
        if (!validarCampos()) return;

        Cliente clienteAntigo = modelo.getCliente(linhas[0]);

        String nome = txtNome.getText();
        String sobrenome = txtSobrenome.getText();
        String rg = txtRg.getText();
        String cpf = txtCpf.getText();
        String endereco = txtEndereco.getText();

        if (banco.existeNomeSobrenomeEmOutro(nome, sobrenome, clienteAntigo)) {
            JOptionPane.showMessageDialog(this, "Já existe outro cliente com o mesmo Nome e Sobrenome.");
            return;
        }
        if (banco.existeRgEmOutro(rg, clienteAntigo)) {
            JOptionPane.showMessageDialog(this, "Já existe outro cliente com o mesmo RG.");
            return;
        }
        if (banco.existeCpfEmOutro(cpf, clienteAntigo)) {
            JOptionPane.showMessageDialog(this, "Já existe outro cliente com o mesmo CPF.");
            return;
        }

        Cliente clienteNovo = new Cliente(nome, sobrenome, rg, cpf, endereco);
        banco.atualizarCliente(clienteAntigo, clienteNovo);
        atualizarTabela(banco.getClientes());
        limparCampos();
        JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
    }

    private void excluirCliente() {
        int[] linhas = tabela.getSelectedRows();
        if (linhas == null || linhas.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um ou mais clientes para excluir!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this,
                "Excluir " + linhas.length + " cliente(s)?\nContas vinculadas serão removidas.",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (resposta != JOptionPane.YES_OPTION) return;

        List<Cliente> aRemover = new ArrayList<>();
        for (int linha : linhas) {
            aRemover.add(modelo.getCliente(linha));
        }
        for (Cliente c : aRemover) {
            banco.removerCliente(c);
        }

        atualizarTabela(banco.getClientes());
        limparCampos();
        JOptionPane.showMessageDialog(this, "Exclusão concluída!");
    }

    private void buscarClientes() {
        String textoBusca = txtBusca.getText().trim();
        if (textoBusca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite algo para buscar!");
            return;
        }

        String tipoBusca = (String) cbTipoBusca.getSelectedItem();
        List<Cliente> resultado;

        switch (tipoBusca) {
            case "Nome":
                resultado = banco.buscarPorNome(textoBusca);
                break;
            case "Sobrenome":
                resultado = banco.buscarPorSobrenome(textoBusca);
                break;
            case "RG":
                Cliente c1 = banco.buscarPorRg(textoBusca);
                resultado = c1 != null ? List.of(c1) : List.of();
                break;
            case "CPF":
                Cliente c2 = banco.buscarPorCpf(textoBusca);
                resultado = c2 != null ? List.of(c2) : List.of();
                break;
            default:
                resultado = banco.getClientes();
        }

        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado!");
        }
        atualizarTabela(resultado);
    }

    private void ordenarClientes() {
        String tipoOrdenacao = (String) cbOrdenacao.getSelectedItem();
        List<Cliente> ordenados = "Nome".equals(tipoOrdenacao)
                ? banco.ordenarPorNome()
                : banco.ordenarPorSobrenome();
        atualizarTabela(ordenados);
    }

    private void preencherFormulario(int linha) {
        Cliente cliente = modelo.getCliente(linha);
        txtNome.setText(cliente.getNome());
        txtSobrenome.setText(cliente.getSobrenome());
        txtRg.setText(cliente.getRg());
        txtCpf.setText(cliente.getCpf());
        txtEndereco.setText(cliente.getEndereco());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtSobrenome.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtEndereco.setText("");
        if (tabela != null) {
            tabela.clearSelection();
        }
    }

    private boolean validarCampos() {
        if (txtNome.getText().trim().isEmpty() ||
                txtSobrenome.getText().trim().isEmpty() ||
                txtRg.getText().trim().isEmpty() ||
                txtCpf.getText().trim().isEmpty() ||
                txtEndereco.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!");
            return false;
        }
        return true;
    }

    private void atualizarTabela(List<Cliente> clientes) {
        modelo.setListaClientes(clientes);
    }
}
