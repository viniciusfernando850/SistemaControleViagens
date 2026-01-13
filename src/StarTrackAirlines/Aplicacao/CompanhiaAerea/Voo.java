package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Voo {
    protected String identificador;
    protected Aeronave aeronave;
    protected Map<String, Assento> assentosVoo;
    protected String origem;
    protected String destino;
    protected LocalDate dataPartida;
    protected LocalTime horarioPartida;
    protected LocalTime horarioChegada;

    protected static final float IBS = 0.1F;
    protected static final float CBS = 0.9F;
    protected static final float TAXA_OCUPACAO_50 = 20F;
    protected static final float TAXA_OCUPACAO_70 = 40F;

    public Voo(String identificador, Aeronave aeronave, Map<String, Assento> assentosVoo, String origem,
               String destino, LocalDate data, LocalTime horarioPartida, LocalTime horarioChegada){

        this.identificador = identificador;
        this.aeronave = aeronave;
        this.assentosVoo = assentosVoo;
        this.origem = origem;
        this.destino = destino;
        this.dataPartida = data;
        this.horarioPartida = horarioPartida;
        this.horarioChegada = horarioChegada;
    }

    public String getIdentificador(){
        return identificador;
    }
    public void setIdentificador(String identificador){ this.identificador = identificador;}

    public Aeronave getAeronave(){
        return aeronave;
    }
    public void setAeronave (Aeronave aeronave){
        this.aeronave = aeronave;
    }

    public Map<String, Assento> getAssentosVoo() {return this.assentosVoo;}
    public void setAssentosVoo(Map<String, Assento> assentosVoo) {this.assentosVoo = assentosVoo;}

    public String getOrigem(){
        return origem;
    }
    public void setOrigem(String origem){
        this.origem = origem;
    }

    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }

    public LocalDate getDataPartida(){
        return dataPartida;
    }
    public void setDataPartida(LocalDate data){
        this.dataPartida = data;
    }

    public LocalTime getHorarioPartida(){
        return horarioPartida;
    }
    public void setHorarioPartida(LocalTime horarioPartida){ this.horarioPartida = horarioPartida;}

    public LocalTime getHorarioChegada(){
        return horarioChegada;
    }
    public void setHorarioChegada(LocalTime horarioChegada){
        this.horarioChegada = horarioChegada;
    }

    public float getIbs() {return IBS;}
    public float getCbs() {return CBS;}
    public float getTaxaOcupacao50() {return TAXA_OCUPACAO_50;}
    public float getTaxaOcupacao70() {return TAXA_OCUPACAO_70;}

    public boolean verificarDisponibilidadeAssentos() {
        boolean existeAssentoLivre = false;

        for (Assento assento : assentosVoo.values())
            if (!assento.getOcupado()) {
                existeAssentoLivre = true;
                break;
            }

        return existeAssentoLivre;
    }

    public boolean verificarDisponibilidadeData() {
        LocalTime horaAtual = LocalTime.now();
        LocalDate dataAtual = LocalDate.now();

        int horaAtualEmMinutos = horaAtual.getHour() * 60 + horaAtual.getMinute();
        int horaPartidaEmMinutos = this.horarioPartida.getHour() * 60 + this.horarioPartida.getMinute();

        if (dataPartida.equals(dataAtual))
            return (horaPartidaEmMinutos - horaAtualEmMinutos) > 20;
        else return dataPartida.isAfter(dataAtual);
    }

    public boolean verificarDisponibilidadeVoo() {
        boolean existeAssentoLivre = verificarDisponibilidadeAssentos();
        boolean dataDisponivel = verificarDisponibilidadeData();

        return (existeAssentoLivre && dataDisponivel);
    }

    public void showVoo(){
        System.out.println("Aeronave: " + this.aeronave.getModelo());
        System.out.println("Origem: " + this.origem);
        System.out.println("Destino: " + this.destino);
        System.out.println("Data: " + this.dataPartida);
        System.out.println("Horário Partida: " + this.horarioPartida);
        System.out.println("Horário Chegada: " + this.horarioChegada);
        System.out.println("Identificador: " + this.identificador);
        System.out.println();
    }

}
