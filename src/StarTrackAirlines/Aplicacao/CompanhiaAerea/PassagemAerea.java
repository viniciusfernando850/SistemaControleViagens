package StarTrackAirlines.Aplicacao.CompanhiaAerea;

public class PassagemAerea {
    private Passageiro passageiro;
    private Voo voo;
    private String reserva;
    private Assento assento;

    private static final double DESCONTO_INFANTIL = 0.5;
    private static final double TAXA_BAGAGEM = 200;

    public PassagemAerea(Voo voo, Passageiro passageiro, Assento assento, String reserva) {
        this.voo = voo;
        this.passageiro = passageiro;
        this.assento = assento;
        this.reserva = reserva;
    }

    // Realizar venda - 2º Fase
        // Obs: laço para adicionar passagens
        // Obs: Tentar modularizar com um metodo para receber dados

    // Metodo ajuste de preço - 3º Fase

    // Metodo para mostrar as reservas realizadas - 4º Fase

    //-------> OLHAR IDEIA NA CLASSE "Cliente" <-------


    public double getDescontoInfantil() {
        return DESCONTO_INFANTIL;
    }
    public double getTaxaBagagem() {
        return TAXA_BAGAGEM;
    }

    public Passageiro getPassageiro() {return passageiro;}
    public void setPassageiro(Passageiro passageiro) {this.passageiro = passageiro;}

    public Voo getVoo() {return voo;}
    public void setVoo(Voo voo) {this.voo = voo;}

    public String getReserva() {return reserva;}
    public void setReserva(String reserva) {this.reserva = reserva;}

    public Assento getAssento() {return assento;}
    public void setAssento(Assento assento) {this.assento = assento;}

    public void showPassagemAerea() {
        System.out.println(this.passageiro.getNome());
        System.out.println(this.voo.getOrigem() + " ---> " + this.voo.getDestino() + "\t\t" + voo.getDataPartida());
        System.out.println("Horário de Partida: " + this.voo.getHorarioPartida() + "\t\t Horário de Chegada: "
                + this.voo.getHorarioChegada());

        System.out.println(this.voo.getAeronave().getModelo() + "\tReserva: " + this.reserva + "\t"
                + this.assento.getCodigoAssento());
        System.out.println();
    }

}
