package AirportSystem.Aplicacao.Aeroporto;

import AirportSystem.Aplicacao.VendaPassagens.CalculadoraTaxa;
import java.util.HashMap;

public class CompanhiaAerea implements CalculadoraTaxa {
    private String nome;
    private float taxaCompanhia;
    private HashMap<String, Aeronave> frota;

    public CompanhiaAerea(String nome, float taxaCompanhia) {
        this.nome = nome;
        this.taxaCompanhia = taxaCompanhia;
        this.frota = new HashMap<>();
    }

    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}

    public float getTaxaCompanhia() {return this.taxaCompanhia;}
    public void setTaxaCompanhia(float taxaCompanhia) {this.taxaCompanhia = taxaCompanhia;}

    public HashMap<String, Aeronave> getFrota() {return this.frota;}
    public void setFrota(HashMap<String, Aeronave> frota) {this.frota = frota;}

    public double calcularTaxa(double tarifaBase) {
        return tarifaBase * taxaCompanhia;
    }

    public void showAeronavesDisponiveis() {
        for (String registro : frota.keySet()) {
            System.out.println(registro);
            System.out.println(frota.get(registro));
        }
    }

}
