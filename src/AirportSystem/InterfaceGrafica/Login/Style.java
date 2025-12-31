package AirportSystem.InterfaceGrafica.Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Style {
    private static Color azulPrussia = new Color(0, 7, 45);
    private static Color azulImperial = new Color(10, 36, 114);
    private static Color brancoNeve = new Color(249, 249, 249);

    public static void designCampo(JTextField campo) {
        campo.setPreferredSize(new Dimension(200, 35));
        campo.setBackground(brancoNeve);
        campo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, azulImperial));
        campo.setOpaque(true);

    }

    public static void designSeletor(JComboBox<String> seletor) {
        seletor.setPreferredSize(new Dimension(200, 25));
        seletor.setBackground(Color.WHITE);
        seletor.setFocusable(false);
        seletor.setOpaque(true);
    }

    public static void designBotao(JButton botao) {
        botao.setPreferredSize(new Dimension(120, 32));
        botao.setBackground(azulImperial);
        botao.setForeground(brancoNeve);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
    }

    public static void designBackground(JPanel painel) {
        painel.setBackground(brancoNeve);
        painel.setBorder(new EmptyBorder(20, 10, 20, 10));
        painel.setPreferredSize(new Dimension(330, 500));

    }
}
