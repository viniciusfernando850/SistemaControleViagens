package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.ControleVendas.Calculavel;

public class Assento {
    private String codigoAssento;
    private int numeroAssento;
    private ClasseAssento classeAssento;
    private boolean ocupado;

    private static final double TARIFA_ASSENTO = 350.0;

    public Assento(int numeroAssento, ClasseAssento classeAssento, boolean ocupado) {
        this.numeroAssento = numeroAssento;
        this.classeAssento = classeAssento;
        this.ocupado = ocupado;

        if (classeAssento.equals(ClasseAssento.PRIMEIRA_CLASSE))
            this.codigoAssento = this.numeroAssento + "A";
        else if (classeAssento.equals(ClasseAssento.EXECUTIVA))
            this.codigoAssento = this.numeroAssento + "E";
        else
            this.codigoAssento = this.numeroAssento + "H";
    }

    public String getCodigoAssento() {return this.codigoAssento;}
    public void setCodigoAssento(String codigoAssento) {this.codigoAssento = codigoAssento;}

    public int getNumeroAssento() {return this.numeroAssento;}
    public void setNumeroAssento(int numeroAssento) {this.numeroAssento = numeroAssento;}

    public ClasseAssento getClasseAssento() {return this.classeAssento;}
    public void setClasseAssento(ClasseAssento classeAssento) {this.classeAssento = classeAssento;}

    public boolean getOcupado() {return this.ocupado;}
    public void setOcupado(boolean ocupado) {this.ocupado = ocupado;}

    public double getTarifaAssento() {return TARIFA_ASSENTO;}

}