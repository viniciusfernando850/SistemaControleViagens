package AirportSystem.Aplicacao.Aeroporto.Assentos;

public enum Executiva {
    BOEING_737(30), AIRBUS_A319(14), AIRBUS_A320(14),  EMBRAER_195(12),
    ATR_72(8), AIRBUS_A350(36), BOEING_787_DREAMLINER(30),
    AIRBUS_A330(34), BOEING_777(38);

    private final int num;
    Executiva(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }
}
