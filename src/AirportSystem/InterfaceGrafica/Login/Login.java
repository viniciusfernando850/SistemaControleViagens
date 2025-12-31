package AirportSystem.InterfaceGrafica.Login;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel contentPainel;
    private JTextField usuario;
    private JTextField senha;
    private JComboBox<String> seletor;
    private JButton botaoEntrar;

    public Login() {
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
        configurarJanela();

        setVisible(true);
    }

    public void configurarJanela() {
        Image icon = new ImageIcon(getClass().getResource(
                "/AirportSystem/InterfaceGrafica/Images/airplane_1.png")).getImage();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Star Track Airport System");
        setIconImage(icon);
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void configurarLayout() {
        contentPainel =
                new PainelBackGround("/AirportSystem/InterfaceGrafica/Images/background-login.jpg");
        contentPainel.setLayout(new BorderLayout());
        setContentPane(contentPainel);

        JPanel painel = new JPanel(new GridBagLayout());
        Style.designBackground(painel);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(20, 5, 20, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        Style.designCampo(this.usuario);
        painel.add(this.usuario, gbc);

        gbc.gridy = 1;
        Style.designCampo(this.senha);
        painel.add(this.senha, gbc);

        gbc.gridy = 2;
        Style.designSeletor(this.seletor);
        painel.add(this.seletor, gbc);

        gbc.insets = new Insets(30, 5, 15, 5);
        gbc.gridy = 3;
        Style.designBotao(this.botaoEntrar);
        painel.add(this.botaoEntrar, gbc);

        contentPainel.add(painel, BorderLayout.WEST);
    }

    private void inicializarComponentes() {
        gerarBotao();
        gerarCampos();
        gerarSeletor();
    }

    private void gerarBotao() {
        this.botaoEntrar = new JButton("Login");
    }

    private void gerarCampos() {
        this.usuario = new JTextField("Usuário");
        this.senha = new JTextField("Senha");
    }

    private void gerarSeletor() {
        this.seletor = new JComboBox<>();

        seletor.addItem("-- Selecione uma opção --");
        seletor.addItem("Seção de Vendas");
        seletor.addItem("Seção de Check-in");
        seletor.addItem("Seção Administrativa");
    }

    private void configurarEventos() {
        TratadorLogin tratadorLogin = new TratadorLogin(this.usuario, this.senha, this.botaoEntrar);

        botaoEntrar.addActionListener(tratadorLogin);
        usuario.addFocusListener(tratadorLogin);
        senha.addFocusListener(tratadorLogin);
    }

    public static void main(String[] args) {
        new Login();
    }
}
