package StarTrackAirlines.Aplicacao;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.*;
import StarTrackAirlines.Controllers.ControleVendas.ControleVendas;
import StarTrackAirlines.Controllers.ControleVoos.*;
import StarTrackAirlines.Controllers.ControleLogin.ControleLogin;
import StarTrackAirlines.InterfaceGrafica.*;
import StarTrackAirlines.InterfaceGrafica.Login.*;
import StarTrackAirlines.InterfaceGrafica.SecaoCheckin.*;
import StarTrackAirlines.InterfaceGrafica.SecaoOperacional.*;
import StarTrackAirlines.InterfaceGrafica.SecaoVendas.*;
import StarTrackAirlines.Aplicacao.Login.Autenticacao;
import StarTrackAirlines.Aplicacao.ManipulacaoArquivos.VoosRepository;

import java.io.IOException;
import java.util.*;

public class SistemaGeral {
    private static final VoosRepository voosRepository = new VoosRepository();

    public static Set<Aeronave> configurarFrota() {
        Aeronave aeronave01 = new Aeronave("Airbus A320");
        Aeronave aeronave02 = new Aeronave("Airbus A350");
        Aeronave aeronave03 = new Aeronave("ATR 72");
        Aeronave aeronave04 = new Aeronave("Boeing 787 Dreamliner");
        Aeronave aeronave05 = new Aeronave("Boeing 777");

        Set<Aeronave> frota = new HashSet<>();
        frota.add(aeronave01);
        frota.add(aeronave02);
        frota.add(aeronave03);
        frota.add(aeronave04);
        frota.add(aeronave05);

        return frota;
    }

    public static Map<String, Voo> configurarListagemVoos(Set<Aeronave> frota) throws IOException {
        return voosRepository.carregarDados(frota);
    }

    public static void configurarInterfaceGrafica(Autenticacao autenticacaoLogin, ControleVoo controleVoo,
                                                  ControleVendas controleVendas) {
        MainWindow window = new MainWindow();

        LoginView loginView = new LoginView();
        SecaoOperacional secaoOperacional = new SecaoOperacional();
        SecaoVendas secaoVendas = new SecaoVendas();
        //SecaoCheckin secaoCheckin = new SecaoCheckin();

        new ControleLogin(window, loginView, autenticacaoLogin);
        //new ControleInterfaceOperacional();
        new ControleInterfaceVendas();

        window.adicionarTela(loginView, "login");
        window.adicionarTela(secaoOperacional, "operacional");
        window.adicionarTela(secaoVendas, "vendas");
        //window.adicionarTela(secaoCheckin, "checkin");

        window.abrirLogin("login");
    }

    public static void main(String[] args) {
        Set<Aeronave> frota = configurarFrota();

        try {
            Map<String, Voo> listagemVoos = configurarListagemVoos(frota);
            CompanhiaAerea companhiaAerea = new CompanhiaAerea("Star Track Airlines", frota, listagemVoos);
            voosRepository.salvarDados(companhiaAerea);

            Autenticacao autenticacaoLogin = new Autenticacao();
            ControleVoo controleVoo = new ControleVoo(companhiaAerea);
            ControleVendas controleVendas = new ControleVendas();

            configurarInterfaceGrafica(autenticacaoLogin, controleVoo, controleVendas);

            /*teste controle
            cadastrar -> SUCESSO T1,SUCESSO T2
            modificar -> SUCESSO T1, T2
            deletar -> SUCESSO T1,
            C exception ->
            M exception ->
            D exception ->
            */
            ControleVoo controle = new ControleVoo(companhiaAerea);
            /*try{
                controle.cadastrarVoo();
            }catch(DadosInvalidosException | AeronaveIndisponivelException e){
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }*/

            for(Voo v : listagemVoos.values()){
                v.showVoo();
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }
}

