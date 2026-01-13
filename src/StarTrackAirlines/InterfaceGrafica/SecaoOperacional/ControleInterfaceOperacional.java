package StarTrackAirlines.InterfaceGrafica.SecaoOperacional;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.Aeronave;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.CompanhiaAerea;
import StarTrackAirlines.Controllers.ControleVoos.ControleVoo;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;



public class ControleInterfaceOperacional extends JFrame {
    private ControleVoo controleVoo;

    public ControleInterfaceOperacional (CompanhiaAerea companhiaAerea) {
        this.controleVoo = new ControleVoo(companhiaAerea);

        setTitle("Controle de Voos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //botoes //
        JPanel painelBotoes = new JPanel(new GridLayout(5, 1, 10, 10));
        painelBotoes.setBorder(BorderFactory.createTitledBorder("Ações"));

        JButton btnCadastrar = new JButton("Cadastrar Voo");
        JButton btnModificar = new JButton("Modificar Voo");
        JButton btnDeletar = new JButton("Deletar Voo");
        JButton btnDeletarAntigos = new JButton("Deletar Voos Antigos");
        JButton btnListar = new JButton("Listar Voos");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnModificar);
        painelBotoes.add(btnDeletar);
        painelBotoes.add(btnDeletarAntigos);
        painelBotoes.add(btnListar);

        add(painelBotoes, BorderLayout.CENTER);

     // adicionando ouvinte aos botoes//
        btnCadastrar.addActionListener(e -> ());
        btnModificar.addActionListener(e -> ());
        btnDeletar.addActionListener(e -> ());
        btnDeletarAntigos.addActionListener(e -> {
            controleVoo.deletarVoosAntigos();
            JOptionPane.showMessageDialog(this, "Voos antigos deletados com sucesso!");
        });


    private void abrirDialogoCadastrar() {
        JDialog dialog = new JDialog(this, "Cadastrar Voo", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(7, 2, 5, 5));

        JTextField txtOrigem = new JTextField();
        JTextField txtDestino = new JTextField();
        JTextField txtData = new JTextField();
        JTextField txtHorarioP = new JTextField();
        JTextField txtHorarioC = new JTextField();
        JTextField txtAeronave = new JTextField();

        dialog.add(new JLabel("Origem:"));
        dialog.add(txtOrigem);
        dialog.add(new JLabel("Destino:"));
        dialog.add(txtDestino);
        dialog.add(new JLabel("Data (dd/MM/yyyy):"));
        dialog.add(txtData);
        dialog.add(new JLabel("Horário Partida (HH:mm):"));
        dialog.add(txtHorarioP);
        dialog.add(new JLabel("Horário Chegada (HH:mm):"));
        dialog.add(txtHorarioC);
        dialog.add(new JLabel("Modelo Aeronave:"));
        dialog.add(txtAeronave);

        JButton btnConfirmar = new JButton("Cadastrar");
        dialog.add(btnConfirmar);
        new JButton("Cancelar") {{
            addActionListener(e -> dialog.dispose());
        }
}
    }