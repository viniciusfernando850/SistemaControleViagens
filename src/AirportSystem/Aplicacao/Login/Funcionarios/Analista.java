package AirportSystem.Aplicacao.Login.Funcionarios;

public class Analista extends Funcionario {
    //private String senha;

    private String senhaAnalista;

    public Analista(String nome, String senha){
        super(nome, senha);
        senhaAnalista = senha;
    }

}
