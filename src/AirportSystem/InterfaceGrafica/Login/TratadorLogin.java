package AirportSystem.InterfaceGrafica.Login;

import javax.swing.*;
import java.awt.event.*;

public class TratadorLogin extends MouseAdapter implements ActionListener, FocusListener {
    private JTextField usuario;
    private JTextField senha;
    private JButton botaoEntrar;

    public TratadorLogin(JTextField usuario, JTextField senha, JButton botaoEntrar) {
        this.usuario = usuario;
        this.senha = senha;
        this.botaoEntrar = botaoEntrar;
    }

    public void actionPerformed(ActionEvent event) {

    }

    public void focusGained(FocusEvent event) {
        JTextField campo = (JTextField) event.getComponent();

        if ((campo == usuario) && campo.getText().equals("Usuário"))
            campo.setText("");
        else if ((campo == senha) && campo.getText().equals("Senha"))
            campo.setText("");

    }

    public void focusLost(FocusEvent event) {
        JTextField campo = (JTextField) event.getComponent();

        if ((campo == usuario) && campo.getText().isEmpty())
            campo.setText("Usuário");
        else if ((campo == senha) && campo.getText().isEmpty())
            campo.setText("Senha");
    }
}
