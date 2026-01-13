package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.ControleVendas.Calculavel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class VooDomestico extends Voo {
    public VooDomestico(String identificador, Aeronave aeronave, Map<String, Assento> assentosVoo, String origem,
                        String destino, LocalDate data, LocalTime horarioSaida, LocalTime horarioChegada) {
        super(identificador, aeronave, assentosVoo, origem, destino, data, horarioSaida, horarioChegada);
    }

    private static final double TARIFA_NACIONAL = 610.45F;
    private static final float ICMS = 12F;

    public double getTarifaNacional() {return TARIFA_NACIONAL;}
    public float getIcms() {return ICMS;}

}
