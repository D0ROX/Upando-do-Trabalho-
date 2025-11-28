package LPO1.T08.T1;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ConcatenaNome extends JFrame {

    // Campos e rótulo
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JLabel lblResultado;

    public ConcatenaNome() {
        setTitle("Concatenador de Nomes em Tempo Real");
        setSize(450, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Componentes
        txtNome = new JTextField();
        txtSobrenome = new JTextField();
        lblResultado = new JLabel("Nome completo aparecerá aqui", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel dos campos
        JPanel painelCentral = new JPanel(new GridLayout(2, 2, 5, 5));
        painelCentral.add(new JLabel("Nome:"));
        painelCentral.add(txtNome);
        painelCentral.add(new JLabel("Sobrenome:"));
        painelCentral.add(txtSobrenome);

        add(painelCentral, BorderLayout.CENTER);
        add(lblResultado, BorderLayout.SOUTH);

        // Atualiza o rodapé a cada mudança de texto (inclui colar/apagar)
        DocumentListener atualizaRodape = new DocumentListener() {
            private void atualizar() {
                String nome = txtNome.getText().trim();
                String sobrenome = txtSobrenome.getText().trim();
                String espaco = (nome.isEmpty() || sobrenome.isEmpty()) ? "" : " ";
                lblResultado.setText(nome + espaco + sobrenome);
            }
            @Override public void insertUpdate(DocumentEvent e) { atualizar(); }
            @Override public void removeUpdate(DocumentEvent e) { atualizar(); }
            @Override public void changedUpdate(DocumentEvent e) { atualizar(); } // não dispara em PlainDocument
        };

        txtNome.getDocument().addDocumentListener(atualizaRodape);
        txtSobrenome.getDocument().addDocumentListener(atualizaRodape);
    }

    public static void main(String[] args) {
        // Cria e mostra a GUI na EDT
        SwingUtilities.invokeLater(() -> {
            ConcatenaNome janela = new ConcatenaNome();
            janela.setLocationRelativeTo(null); // centraliza
            janela.setVisible(true);
        });
    }
}
