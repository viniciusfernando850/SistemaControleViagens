package StarTrackAirlines.Aplicacao.CompanhiaAerea;

import java.time.LocalDate;

public class Passageiro {
    private String nome;
    private int idade;
    private String cpf;
    private String passaporte;
    private int bagagens;
    //private boolean bagagens;
    /*
    IDEIA:
        Criar um atributo de tipo Lista em cliente para guardar o identificador de todas as passagens associadas à ele;
        Ao invés de colocar o metodo de mostrar as reservas realizadas em PassagemAerea, manter esse metodo em CLiente;
        Usando a lista, poderiamos chamar todas as passagens associadas com algo similar à:

        public void mostrarVoos(ArrayList<Voo> voos){
        for(Voo v : voos){
            System.out.println(v.getOrigem() + " ---> " + v.getDestino() + " Saída:" + v.getHorarioPartida() + " // Chegada:" + v.getHorarioChegada() + ".\nID: " + v.getIdentificador() + " Av:" + v.getModeloAviao());
        }
     */

    public Passageiro(String nome, LocalDate dataNascimento, String cpf, String passaporte, int bagagens) {
        this.nome = nome;
        this.idade = calcularIdade(dataNascimento);
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.bagagens = bagagens;
    }

    public Passageiro(String nome, LocalDate dataNascimento, String cpf, int bagagens) {
        this(nome, dataNascimento, cpf, "---", bagagens);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }
    public void setPassaporte(String passaporte) {this.passaporte = passaporte;}

    public int getBagagens() {
        return bagagens;
    }
    public void setBagagens(int bagagens) {
        this.bagagens = bagagens;
    }

    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();

        if (dataAtual.isBefore(dataNascimento))
            return dataAtual.getYear() - dataNascimento.getYear() - 1;

        return dataAtual.getYear() - dataNascimento.getYear();
    }

}
