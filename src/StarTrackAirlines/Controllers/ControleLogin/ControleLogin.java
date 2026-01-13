package StarTrackAirlines.Controllers.ControleLogin;

import StarTrackAirlines.Aplicacao.Login.Autenticacao;
import StarTrackAirlines.Aplicacao.Login.Exceptions.DadosInvalidosException;
import StarTrackAirlines.Aplicacao.Login.Funcionario;
import StarTrackAirlines.Aplicacao.Login.Perfil;
import StarTrackAirlines.InterfaceGrafica.Login.LoginView;
import StarTrackAirlines.InterfaceGrafica.Login.StyleLogin;
import StarTrackAirlines.InterfaceGrafica.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ControleLogin {
    private final MainWindow mainWindow;
    private final LoginView loginView;
    private final Autenticacao autenticacao;

    public ControleLogin(MainWindow mainWindow, LoginView loginView, Autenticacao autenticacao) {
        this.mainWindow = mainWindow;
        this.loginView = loginView;
        this.autenticacao = autenticacao;

        configurarEventos();
    }

    private void configurarEventos() {
        loginView.setFocusable(true);
        loginView.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                loginView.requestFocusInWindow();
            }
        });

        JTextField usuario = loginView.getUsuario();
        JPasswordField senha = loginView.getSenha();
        JButton botaoEntrar = loginView.getBotaoEntrar();

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin(usuario.getText(), senha.getPassword());
            }
        });

        botaoEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StyleLogin.designBotaoPressionado(botaoEntrar, 120, 32);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                StyleLogin.designBotao(botaoEntrar, 120, 32);
            }
        });

    }

    public void realizarLogin(String usuario, char[] senha) {

        try {
            Funcionario funcionario = autenticacao.validarLogin(usuario, senha);
            String tela;

            if (funcionario.getPerfil() == Perfil.ADMIN) {
                tela = "operacional";
                mainWindow.abrirOperacional(tela);
            } else if (funcionario.getPerfil() == Perfil.VENDEDOR) {
                tela = "vendas";
                mainWindow.abrirVendas(tela);
            } else if (funcionario.getPerfil() == Perfil.AGENTE_CHECKIN) {
                tela = "checkin";
                mainWindow.abrirCheckin(tela);
            }

        } catch (DadosInvalidosException e) {
            System.out.println(e.getMessage());
            loginView.configurarMensagemErro(mainWindow);
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
