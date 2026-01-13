package StarTrackAirlines.Controllers.ControleVendas;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.Assento;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.ClasseAssento;
import StarTrackAirlines.Aplicacao.CompanhiaAerea.Voo;

public class CalculoPrecoAssento implements Calculavel<Voo, Assento> {

    private int calcularTotalAssentosOcupados(Voo voo, ClasseAssento classeAssento) {
        int totalAssentosOcupados = 0;

        for (Assento assento : voo.getAssentosVoo().values()) {
            if (!assento.getClasseAssento().equals(classeAssento))
                continue;

            if (assento.getOcupado())
                totalAssentosOcupados++;
        }

        return totalAssentosOcupados;
    }

    private double calcularAcrescimoPorOcupacao(Voo voo, Assento assentoEscolhido,
                                                ClasseAssento classeAssento, int totalAssentosOcupados) {

        double tarifaAssento = assentoEscolhido.getTarifaAssento();

        double acrescimoOcupacao50 = tarifaAssento + (tarifaAssento * voo.getTaxaOcupacao50());
        double acrescimoOcupacao70 = tarifaAssento + (tarifaAssento * voo.getTaxaOcupacao70());

        float taxaEconomica = ClasseAssento.ECONOMICA.getTaxa();
        float taxaExecutiva = ClasseAssento.EXECUTIVA.getTaxa();
        float taxaPrimeiraClasse = ClasseAssento.PRIMEIRA_CLASSE.getTaxa();

        if (classeAssento.equals(ClasseAssento.PRIMEIRA_CLASSE)) {
            if (totalAssentosOcupados >= voo.getAeronave().getAssentosPrimeiraClasse() * 70 / 100)
                return tarifaAssento + (acrescimoOcupacao70 * taxaPrimeiraClasse);
            else if (totalAssentosOcupados >= voo.getAeronave().getAssentosPrimeiraClasse() * 50 / 100)
                return tarifaAssento + (acrescimoOcupacao50 * taxaPrimeiraClasse);

            return tarifaAssento + (tarifaAssento * taxaPrimeiraClasse);

        } else if (classeAssento.equals(ClasseAssento.EXECUTIVA)) {
            if (totalAssentosOcupados >= voo.getAeronave().getAssentosExecutiva() * 70 / 100)
                return tarifaAssento + (acrescimoOcupacao70 * taxaExecutiva);
            else if (totalAssentosOcupados >= voo.getAeronave().getAssentosExecutiva() * 50 / 100)
                return tarifaAssento + (acrescimoOcupacao50 * taxaExecutiva);

            return tarifaAssento + (tarifaAssento * taxaExecutiva);

        }

        if (totalAssentosOcupados >= voo.getAeronave().getAssentosEconomica() * 70 / 100)
            return tarifaAssento + (acrescimoOcupacao70 * taxaEconomica);
        else if (totalAssentosOcupados >= voo.getAeronave().getAssentosEconomica() * 50 / 100)
            return tarifaAssento + (acrescimoOcupacao50 * taxaEconomica);

        return tarifaAssento + (tarifaAssento * taxaEconomica);
    }

    @Override
    public double calcular(Voo voo, Assento assentoEscolhido) {
        ClasseAssento classeAssento = assentoEscolhido.getClasseAssento();

        int totalAssentosOcupados = calcularTotalAssentosOcupados(voo, classeAssento);

        return calcularAcrescimoPorOcupacao(voo, assentoEscolhido, classeAssento, totalAssentosOcupados);
    }
}
