package AirportSystem.Aplicacao.Login.Funcionarios;

public class Operador extends Funcionario{

    private String senhaOperador;

    public Operador(String nome, String senha){
        super(nome, senha);
        senhaOperador = senha;
    }

}
