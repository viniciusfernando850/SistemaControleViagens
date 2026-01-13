package StarTrackAirlines.Controllers.ControleVendas;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.*;
import StarTrackAirlines.Controllers.ControleVendas.Exception.VoosNaoEncontradosException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ControleVendas {

    public void mostrarVoosEncontrados(ArrayList<Voo> voosEncontrados){
        for(Voo voo : voosEncontrados){
            System.out.println(voo.getOrigem() + " ---> " + voo.getDestino());
            System.out.println("Horário de Partida: " + voo.getHorarioPartida() +
                                "\t\tHorário de Chegada: " + voo.getHorarioChegada());

            System.out.println("Data de partida: " + voo.getDataPartida() + "Aeronave: " + voo.getAeronave());
            System.out.println();
        }
    }

    public List<Voo> pesquisarVoos(CompanhiaAerea companhiaAerea, String origem, String destino)
            throws VoosNaoEncontradosException {

        List<Voo> voosEncontrados = new ArrayList<>();

        for(Voo voo : companhiaAerea.getListagemVoos().values()){
            if(origem.equalsIgnoreCase(voo.getOrigem()) && destino.equalsIgnoreCase(voo.getDestino())) {
                boolean vooDisponivel = voo.verificarDisponibilidadeVoo();

                if (vooDisponivel)
                    voosEncontrados.add(voo);
            }
        }

        if(voosEncontrados.isEmpty())
            throw new VoosNaoEncontradosException("Nenhum voo encontrado para " + destino + ".");

        return voosEncontrados;
    }

    private double[] calcularValorPassagens(PassagemAerea[] passagensAereas){
        double[] valorPassagens = new double[passagensAereas.length];

        CalculoPrecoAssento calculoPrecoAssento = new CalculoPrecoAssento();
        CalculoTaxaNaturezaVoo calculoTaxaNaturezaVoo = new CalculoTaxaNaturezaVoo();

        for (int i = 0; i < passagensAereas.length; i++) {
            double precoAssento = calculoPrecoAssento.calcular(passagensAereas[i].getVoo(),
                                passagensAereas[i].getAssento());

            double taxaNaturezaVoo = calculoTaxaNaturezaVoo.calcular(passagensAereas[i].getVoo(), precoAssento);

            valorPassagens[i] = taxaNaturezaVoo + precoAssento;
        }

        return valorPassagens;
    }

    private Passageiro solicitarDadosPassageiro(Scanner sc, Voo voo) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Data de Nascimento: ");
        String data = sc.nextLine();

        LocalDate dataNascimento = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Número de Bagagens Despachadas: ");
        int numeroBagagens = sc.nextInt();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        if (voo instanceof VooInternacional) {
            System.out.print("Passaporte: ");
            String passaporte = sc.nextLine();

            return new Passageiro(nome, dataNascimento, cpf, passaporte, numeroBagagens);
        }

        return new Passageiro(nome, dataNascimento, cpf, numeroBagagens);
    }

    private void showPassagens(PassagemAerea[] passagensAereas, double[] valorPassagens) {
        for (PassagemAerea passagemAerea : passagensAereas)
            passagemAerea.showPassagemAerea();
    }

    public void realizarVenda(Voo voo, int numeroPassageiros) {
        Scanner sc = new Scanner(System.in);
        PassagemAerea[] passagensAereas = new PassagemAerea[numeroPassageiros];
        Passageiro[] passageiros = new Passageiro[numeroPassageiros];

        for (int i = 0; i < numeroPassageiros; i++) {
            passageiros[i] = solicitarDadosPassageiro(sc, voo);

            System.out.println();

            System.out.println("Assento desejado: ");
            Assento assento = voo.getAssentosVoo().get("A10");

            String reserva = "A86TN";

            passagensAereas[i] = new PassagemAerea(voo, passageiros[i], assento, reserva);

        }

        double[] valorPassagens = calcularValorPassagens(passagensAereas);

        showPassagens(passagensAereas, valorPassagens);

    }

}
