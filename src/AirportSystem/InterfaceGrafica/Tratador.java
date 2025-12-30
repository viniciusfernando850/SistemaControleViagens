package AirportSystem.InterfaceGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tratador implements ActionListener {
    private JButton voltar;
    private JButton avancar;
    private JTextField usuario;

    public Tratador(JButton voltar, JButton avancar, JTextField usuario) {
        this.voltar = voltar;
        this.avancar = avancar;
        this.usuario = usuario;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == avancar) {
            avancar.setText("Avançando");
            usuario.setText("");
        }
        else if (e.getSource() == voltar)
            voltar.setText("Voltando");
    }
}
