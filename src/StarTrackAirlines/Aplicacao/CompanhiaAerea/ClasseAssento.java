package StarTrackAirlines.Aplicacao.CompanhiaAerea;

public enum ClasseAssento {
    ECONOMICA(10),
    EXECUTIVA(20),
    PRIMEIRA_CLASSE(30);

    private final float taxa;
    ClasseAssento(float taxa) {this.taxa = taxa;}

    public float getTaxa() {return this.taxa;}
}
