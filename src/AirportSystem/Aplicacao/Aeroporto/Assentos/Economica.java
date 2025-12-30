package AirportSystem.Aplicacao.Aeroporto.Assentos;

public enum Economica {
    BOEING_737(186), AIRBUS_A319(144), AIRBUS_A320(180),  EMBRAER_195(136),
    ATR_72(72), AIRBUS_A350(281), BOEING_787_DREAMLINER(213),
    AIRBUS_A330(234), BOEING_777(314);

    private final int num;
    Economica(int valor){
        num = valor;
    }

    public int getNum(){
        return num;
    }
}
