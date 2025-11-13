package T08.T2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Conversor: litros -> galões
public class ConversorVolume extends JFrame implements ActionListener {

    private static final double LITROS_POR_GALAO = 3.78541 ;

    private JTextField txtLitros;
    private JButton btnConverter;
    private JLabel lblResultado;
    private JLabel lblGaloes;

    public ConversorVolume() {
        setTitle("Conversor Litros para Galões");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        txtLitros = new JTextField(10);
        txtLitros.setToolTipText("Digite litros (ex.: 10.5)");

        btnConverter = new JButton("Converter");
        btnConverter.addActionListener(this);

        lblGaloes = new JLabel("Galões:");
        lblResultado = new JLabel("0.000");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));

        add(new JLabel("Litros:"));
        add(txtLitros);
        add(btnConverter);
        add(lblGaloes);
        add(lblResultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorVolume janela = new ConversorVolume();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = txtLitros.getText().trim();
        try {
            double litros = Double.parseDouble(texto);
            if (litros < 0) {
                lblResultado.setText("Erro!");
                return;
            }
            double galoes = litros / LITROS_POR_GALAO;
            lblResultado.setText(String.format("%.3f", galoes));
        } catch (NumberFormatException ex) {
            lblResultado.setText("Erro!");
        }
    }
}

