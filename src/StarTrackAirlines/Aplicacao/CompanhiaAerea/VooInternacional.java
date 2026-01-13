package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.ControleVendas.Calculavel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class VooInternacional extends Voo {
    public VooInternacional(String identificador, Aeronave aeronave, Map<String, Assento> assentosVoo, String origem,
                            String destino, LocalDate data, LocalTime horarioSaida, LocalTime horarioChegada) {
        super(identificador, aeronave, assentosVoo, origem, destino, data, horarioSaida, horarioChegada);
    }

    private static final double TARIFA_INTERNACIONAL = 3215.25F;
    private static final float IOF = 3.5F;

    public double getTarifaInternacional() {return TARIFA_INTERNACIONAL;}
    public float getIof() {return IOF;}

}
