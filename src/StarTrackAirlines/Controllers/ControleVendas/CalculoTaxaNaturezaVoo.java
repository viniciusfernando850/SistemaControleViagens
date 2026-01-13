package StarTrackAirlines.Controllers.ControleVendas;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.Voo;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.VooDomestico;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.VooInternacional;

public class CalculoTaxaNaturezaVoo implements Calculavel<Voo, Double> {

    private double calcularTaxaDomestico(Voo voo, double precoAssento) {
        double tarifaNacional = ((VooDomestico) voo).getTarifaNacional();
        float taxaICMS = ((VooDomestico) voo).getIcms();

        return (tarifaNacional * taxaICMS / 100) + (tarifaNacional * voo.getCbs() / 100)
                + (tarifaNacional * voo.getIbs() / 100) + (precoAssento * taxaICMS / 100);
    }

    private double calcularTaxaInternacional(Voo voo, double precoAssento) {
        double tarifaInternacional = ((VooInternacional) voo).getTarifaInternacional();
        float taxaIOF = ((VooInternacional) voo).getIof();

        return (tarifaInternacional * taxaIOF / 100) + (tarifaInternacional * voo.getCbs() / 100)
                + (tarifaInternacional * voo.getIbs() / 100) + (precoAssento * taxaIOF / 100);
    }

    @Override
    public double calcular(Voo voo, Double precoAssento) {
        if (voo instanceof VooDomestico) {
            return calcularTaxaDomestico(voo, precoAssento);
        }

        return calcularTaxaInternacional(voo, precoAssento);
    }
}
