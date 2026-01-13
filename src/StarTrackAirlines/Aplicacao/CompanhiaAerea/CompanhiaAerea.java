package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import StarTrackAirlines.Controllers.ControleVendas.Calculavel;

import java.util.*;

public class  CompanhiaAerea {
    private String nome;
    private Set<Aeronave> frota;
    private Map<String, Voo> listagemVoos;
    private static final float TAXA_COMPANHIA = 0.35F;
    private static final float TARIFA_COMPANHIA = 500.0F;

    public CompanhiaAerea(String nome, Set<Aeronave> frota, Map<String, Voo> listagemVoos) {
        this.nome = nome;
        this.frota = frota;
        this.listagemVoos = listagemVoos;
    }

    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Set<Aeronave> getFrota() {return this.frota;}
    public void setFrota(Set<Aeronave> frota) {this.frota = frota;}

    public Map<String, Voo> getListagemVoos() {return this.listagemVoos;}
    public void setListagemVoos(Map<String, Voo> listagemVoos) {this.listagemVoos = listagemVoos;}

    public double calcularTaxa(double tarifaBase) {
        return TARIFA_COMPANHIA * TAXA_COMPANHIA;
    }

    public void showAeronavesDisponiveis() {
        for (Aeronave aeronave : frota) {
            System.out.println(aeronave.getModelo());
        }
    }

    //Lista temporária para teste da pesquisa de voos em PassagemAerea
    private ArrayList<Voo> voosDisponiveis = new ArrayList<>();
    public ArrayList<Voo> getVoosDisponiveis(){return voosDisponiveis;}

}
