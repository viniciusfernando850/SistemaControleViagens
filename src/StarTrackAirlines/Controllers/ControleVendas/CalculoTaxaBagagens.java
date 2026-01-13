package StarTrackAirlines.Controllers.ControleVendas;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.PassagemAerea;

public class CalculoTaxaBagagens implements Calculavel<PassagemAerea> {

    public double calcular(PassagemAerea passagemAerea) {
        return passagemAerea.getPassageiro().getBagagens() * passagemAerea.getTaxaBagagem() ;
    }
}
