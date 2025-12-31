package AirportSystem.InterfaceGrafica.Login;

import javax.swing.*;
import java.awt.*;

public class PainelBackGround extends JPanel {
    private Image imagem;

    public PainelBackGround(String caminhoImagem) {
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}
