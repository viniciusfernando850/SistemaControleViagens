package AirportSystem.InterfaceGrafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login extends JFrame {
    private JPanel contentPanel;

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel(new BorderLayout());
        setContentPane(contentPanel);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuário"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(200, 22));
        panel.add(usuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Chave de Acesso"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JPasswordField senha = new JPasswordField();
        senha.setPreferredSize(new Dimension(200, 22));
        panel.add(senha, gbc);

        JComboBox<String> instituicao = new JComboBox<String>();
        instituicao.setPreferredSize(new Dimension(200, 22));
        instituicao.addItem("Nenhuma selecionada");
        instituicao.addItem("Universidade Federal do Ceará");
        instituicao.addItem("Universidade Estadual do Ceará");
        instituicao.addItem("Instituto de Tecnologia do Ceará");

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Instituição"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(instituicao, gbc);

        gbc.insets = new Insets(20, 5, 5, 0);

        JPanel panel1 = new JPanel(new FlowLayout());

        JButton voltar = new JButton("Voltar");
        JButton avancar = new JButton("Avançar");

        Tratador tratador = new Tratador(voltar, avancar, usuario);

        avancar.addActionListener(tratador);
        voltar.addActionListener(tratador);

        panel1.add(voltar);
        panel1.add(avancar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(panel1, gbc);

        contentPanel.add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
