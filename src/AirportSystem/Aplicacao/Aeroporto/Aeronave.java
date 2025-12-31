package AirportSystem.Aplicacao.Aeroporto;
import AirportSystem.Aplicacao.Aeroporto.Assentos.Modelos;
import AirportSystem.Aplicacao.Aeroporto.Assentos.PrimeiraClasse;
import AirportSystem.Aplicacao.Aeroporto.Assentos.Executiva;
import AirportSystem.Aplicacao.Aeroporto.Assentos.Economica;

import static AirportSystem.Aplicacao.Aeroporto.Assentos.PrimeiraClasse.AIRBUS_A320;

public class Aeronave {

    private String modelo;
    private int assentosExecutiva;
    private int assentosEconomica;
    private int assentosPrimeiraClasse;

    public Aeronave(String modelo) {
        // Acesso ao arquivo
        this.modelo = modelo;
        if(modelo.equalsIgnoreCase(Modelos.AIRBUS_A320.getNome())){
            assentosPrimeiraClasse = PrimeiraClasse.AIRBUS_A320.getNum();
            assentosExecutiva = Executiva.AIRBUS_A320.getNum();
            assentosEconomica = Economica.AIRBUS_A320.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.AIRBUS_A319.getNome())){
            assentosPrimeiraClasse = PrimeiraClasse.AIRBUS_A319.getNum();
            assentosExecutiva = Executiva.AIRBUS_A319.getNum();
            assentosEconomica = Economica.AIRBUS_A319.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.BOEING_737.getNome())) {
            assentosPrimeiraClasse = PrimeiraClasse.BOEING_737.getNum();
            assentosExecutiva = Executiva.BOEING_737.getNum();
            assentosEconomica = Economica.BOEING_737.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.EMBRAER_195.getNome())){
            assentosPrimeiraClasse = PrimeiraClasse.EMBRAER_195.getNum();
            assentosExecutiva = Executiva.EMBRAER_195.getNum();
            assentosEconomica = Economica.EMBRAER_195.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.ATR_72.getNome())){
            assentosPrimeiraClasse = PrimeiraClasse.ATR_72.getNum();
            assentosExecutiva = Executiva.ATR_72.getNum();
            assentosEconomica = Economica.ATR_72.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.AIRBUS_A350.getNome())) {
            assentosPrimeiraClasse = PrimeiraClasse.AIRBUS_A350.getNum();
            assentosExecutiva = Executiva.AIRBUS_A350.getNum();
            assentosEconomica = Economica.AIRBUS_A350.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.BOEING_787_DREAMLINER.getNome())) {
            assentosPrimeiraClasse = PrimeiraClasse.BOEING_787_DREAMLINER.getNum();
            assentosExecutiva = Executiva.BOEING_787_DREAMLINER.getNum();
            assentosEconomica = Economica.BOEING_787_DREAMLINER.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.AIRBUS_A330.getNome())) {
            assentosPrimeiraClasse = PrimeiraClasse.AIRBUS_A330.getNum();
            assentosExecutiva = Executiva.AIRBUS_A330.getNum();
            assentosEconomica = Economica.AIRBUS_A330.getNum();
        }else if(modelo.equalsIgnoreCase(Modelos.BOEING_777.getNome())) {
            assentosPrimeiraClasse = PrimeiraClasse.BOEING_777.getNum();
            assentosExecutiva = Executiva.BOEING_777.getNum();
            assentosEconomica = Economica.BOEING_777.getNum();
        }else{
            System.out.println("Aeronave não disponível");
        }
    }

    public void setModelo(String modelo){
        if(modelo != null){
            this.modelo = modelo;
        }
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setAssentosEconomica(int assentosEconomica){
        if(assentosEconomica != 0){
            this.assentosEconomica = assentosEconomica;
        }
    }

    public int getAssentosEconomica(){
        return this.assentosEconomica;
    }

    public void setAssentosExecutiva(int assentosExecutiva){
        if(assentosExecutiva != 0){
            this.assentosExecutiva = assentosExecutiva;
        }
    }

    public int getAssentosExecutiva(){
        return this.assentosExecutiva;
    }

    public void setAssentosPrimeiraClasse(int assentosPrimeiraClasse){
        if(assentosPrimeiraClasse != 0){
            this.assentosPrimeiraClasse = assentosPrimeiraClasse;
        }
    }

    public int getAssentosPrimeiraClasse(){
        return this.assentosPrimeiraClasse;
    }


    public int numTotalAssentos(){
        int soma = this.assentosEconomica + this.assentosPrimeiraClasse + this.assentosExecutiva;
        return soma;
    }

    // Metodo show para mostrar dados da aeronave
    public void show(){
        System.out.println("O modelo da aeronave é :" + this.modelo);
        System.out.println("A capacidade máxima da aeronave é :" + this.numTotalAssentos());
        System.out.println("O valor máximo de peso que a aeronave suporta é :");
        System.out.println("O modelo da aeronave é :");
    }



}
