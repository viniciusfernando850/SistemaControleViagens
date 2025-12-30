package AirportSystem.Aplicacao.Login.Funcionarios;

public class Agente extends Funcionario{

    private String senhaAgente;

    public Agente(String nome, String senha){
        super(nome, senha);
        senhaAgente = senha;
    }
}
