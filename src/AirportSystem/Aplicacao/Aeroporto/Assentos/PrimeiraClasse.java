package AirportSystem.Aplicacao.Aeroporto.Assentos;

public enum PrimeiraClasse {
    BOEING_737(16), AIRBUS_A319(12), AIRBUS_A320(12),  EMBRAER_195(0),
    ATR_72(0), AIRBUS_A350(6), BOEING_787_DREAMLINER(8),
    AIRBUS_A330(8), BOEING_777(12);

    private final int num;
    PrimeiraClasse(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }

}
