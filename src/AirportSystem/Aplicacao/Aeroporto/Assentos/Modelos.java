package AirportSystem.Aplicacao.Aeroporto.Assentos;

public enum Modelos {
    BOEING_737("Boeing"), AIRBUS_A319("Airbus A319"), AIRBUS_A320("Airbus A320"), EMBRAER_195("Embraer 195"),
    ATR_72("ATR 72"), AIRBUS_A350("Airbus A350"), BOEING_787_DREAMLINER("Boeing 787 Dreamliner"),
    AIRBUS_A330("Airbus A330"), BOEING_777("Boeing 777");

    private final String nome;
    Modelos(String modelo){
        nome = modelo;
    }


    public String getNome(){
        return nome;
    }
}
