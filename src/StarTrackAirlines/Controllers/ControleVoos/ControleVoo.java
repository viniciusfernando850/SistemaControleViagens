package StarTrackAirlines.Controllers.ControleVoos;

import StarTrackAirlines.Aplicacao.CompanhiaAerea.*;
import StarTrackAirlines.Controllers.ControleVoos.Exception.*;
import StarTrackAirlines.Aplicacao.ManipulacaoArquivos.ControleRepository;
import StarTrackAirlines.Aplicacao.ManipulacaoArquivos.VoosRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class ControleVoo {
    private final CompanhiaAerea companhia;

    public ControleVoo(CompanhiaAerea companhia){
        this.companhia = companhia;
    }

    //---------- Métodos auxiliares -------------
    private final Scanner scanner = new Scanner(System.in);

    private int lerInt(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido, tente novamente: ");
            scanner.next(); // descarta entrada incorreta
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa buffer
        return valor;
    }

    private String lerLinha(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }

    //-----------------------------------------------------------------
    public void cadastrarVoo() throws AeronaveIndisponivelException, DadosInvalidosException {
        System.out.println("Início do cadastro de um voo\n");
        //origem
        String origem = lerLinha("Insira a origem do voo: ");
        boolean orig = false;
        try {
            ControleRepository cr = new ControleRepository();
            ArrayList<String[]> locais = cr.carregarDados();
            if (origem.isEmpty()) {
                throw new DadosInvalidosException("Campo origem vazio.");
            } else {
                for (String[] dados : locais) {
                    if (origem.equalsIgnoreCase(dados[0])) {
                        if (dados[1].equals("NACIONAL")) {
                            orig = true;
                        }
                    } else {
                        throw new DadosInvalidosException("Origem não encontrada.");
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        //destino
        String destino = lerLinha("Insira o destino do voo: ");
        boolean dest = false;
        try {
            ControleRepository cr = new ControleRepository();
            ArrayList<String[]> locais = cr.carregarDados();
            if (destino.isEmpty()) {
                throw new DadosInvalidosException("Campo destino vazio.");
            } else {
                for (String[] dados : locais) {
                    if (destino.equalsIgnoreCase(dados[0])) {
                        if (dados[1].equals("NACIONAL")) {
                            dest = true;
                        }
                    } else {
                        throw new DadosInvalidosException("Destino não encontrado.");
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        //data
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = lerLinha("Insira o ano, o mês e o dia no formato dd/mm/aaaa (ex: 18/01/2004): ");
        LocalDate dataAMD = null;
        if (data.isEmpty()) {
            throw new DadosInvalidosException("Campo data vazio.");
        } else {
            try {
                dataAMD = LocalDate.parse(data, formatterD);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use --MM-dd.");
            }
        }
        //horarios
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horarioP = lerLinha("Insira a hora de partida do voo (formato HH:mm, por exemplo 14:30): ");
        LocalTime horaP = LocalTime.of(0, 0, 0);
        if (horarioP.isEmpty()) {
            throw new DadosInvalidosException("Campo horário de partida vazio.");
        } else {
            try {
                horaP = LocalTime.parse(horarioP, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Erro: Formato de hora inválido. Por favor, use HH:mm (exemplo 14:30).");
            }
        }
        String horarioC = lerLinha("Insira a hora de chegada do voo (formato HH:mm, por exemplo 14:30): ");
        LocalTime horaC = LocalTime.of(0, 0, 0);
        if (horarioC.isEmpty()) {
            throw new DadosInvalidosException("Campo horário de chegada vazio.");
        } else {
            try {
                horaC = LocalTime.parse(horarioC, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Erro: Formato de hora inválido. Por favor, use HH:mm (exemplo 14:30).");
            }
        }
        //aeronave
        Set<Aeronave> frota = companhia.getFrota();
        Map<String, Voo> voos = companhia.getListagemVoos();
        String nomeAeronave = lerLinha("Insira o modelo da aeronave: ");
        Aeronave aero = null;
        Map<String, Assento> assentos = null;
        boolean achouA = false;
        boolean achouV = false;
        if (nomeAeronave.isEmpty()) {
            throw new DadosInvalidosException("Campo aeronave vazio.");
        } else {
            for (Aeronave a : frota) {
                if (a.getModelo().equalsIgnoreCase(nomeAeronave)) {
                    achouA = true;
                    for (Voo v : voos.values()) {
                        if (v.getDataPartida().equals(dataAMD)) {
                            if (v.getAeronave().getModelo().equals(a.getModelo())) {
                                achouV = true;
                            }
                        }
                    }
                    if(achouV){
                        throw new AeronaveIndisponivelException("A aeronave selecionada já está com " +
                                "outro voo agendado nesse dia.");
                    }else {
                        aero = a;
                        assentos = a.gerarAssentos();
                    }
                }
                //if(!achouA) {
                //    throw new AeronaveIndisponivelException("Modelo de aeronave indisponível em nossa companhia.");
                //}
            }
            if(!achouA) {
                throw new AeronaveIndisponivelException("Modelo de aeronave indisponível em nossa companhia.");
            }
        }
        //identificador
        String id = null;
        boolean continua = true;
        boolean igual;
        while(continua){
            igual = false;
            Random rand = new Random();
            int idRTemp = rand.nextInt(1000000);
            String idTemp = String.valueOf(idRTemp);
            for(Voo v : voos.values()){
                if(v.getIdentificador().equalsIgnoreCase(idTemp)){
                    igual = true;
                    idTemp = null;
                    break;
                }
            }
            if(!igual){
                id = idTemp;
                continua = false;
            }
        }
        Voo voo;
        if (orig && dest) {
            voo = new VooDomestico(id, aero, assentos, origem, destino, dataAMD, horaP, horaC);
        } else {
            voo = new VooInternacional(id, aero, assentos, origem, destino, dataAMD, horaP, horaC);
        }
        companhia.getListagemVoos().put(id, voo);
        try {
            VoosRepository cr = new VoosRepository();
            cr.salvarDados(companhia);
            System.out.println("Voo cadastrado com sucesso");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        System.out.println("O identificador do voo é: " + voo.getIdentificador());

    }

    public void modificarVooData(Voo voo) throws DadosInvalidosException {
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM");
        String mudData = lerLinha("Insira a nova data no formato dd/mm (ex: 18/01 para 18 de janeiro): ");
        LocalDate dataNova = null;
        if (mudData.isEmpty()) {
            throw new DadosInvalidosException("Campo data vazio.");
        } else {
            try {
                dataNova = LocalDate.parse(mudData, formatterD);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Formato de data inválido. Use --MM-dd.");
            }
        }
        voo.setDataPartida(dataNova);
        try {
            VoosRepository cr = new VoosRepository();
            cr.salvarDados(companhia);
            System.out.println("Voo modificado com sucesso");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void modificarVooHoraPartida(Voo voo) throws DadosInvalidosException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String mudHorarioP = lerLinha("Insira o novo horário de partida do voo (formato HH:mm, por exemplo 14:30): ");
            LocalTime novaHoraP = LocalTime.of(0, 0, 0);
            if (mudHorarioP.isEmpty()) {
                throw new DadosInvalidosException("Campo horário de partida vazio.");
            } else {
                try {
                    novaHoraP = LocalTime.parse(mudHorarioP, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Erro: Formato de hora inválido. Por favor, use HH:mm (exemplo 14:30).");
                }
            }
            voo.setHorarioPartida(novaHoraP);
            try {
                VoosRepository cr = new VoosRepository();
                cr.salvarDados(companhia);
                System.out.println("Voo modificado com sucesso");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
    }

    public void modificarVooHoraChegada(Voo voo) throws DadosInvalidosException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String mudHorarioC = lerLinha("Insira o novo horário de chegada do voo (formato HH:mm, por exemplo 14:30): ");
        LocalTime novaHoraC = LocalTime.of(0, 0, 0);
        if (mudHorarioC.isEmpty()) {
            throw new DadosInvalidosException("Campo horário de chegada vazio.");
        } else {
            try {
                novaHoraC = LocalTime.parse(mudHorarioC, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Erro: Formato de hora inválido. Por favor, use HH:mm (exemplo 14:30).");
            }
        }
        voo.setHorarioPartida(novaHoraC);
        try {
            VoosRepository cr = new VoosRepository();
            cr.salvarDados(companhia);
            System.out.println("Voo modificado com sucesso");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void modificarVoo() throws DadosInvalidosException, IdentificadorVooInvalidoException{
        Set<Aeronave> frota = companhia.getFrota();
        Map<String, Voo> Voos = companhia.getListagemVoos();
        Voo voo = null;
        boolean achouIdM = false;
        String identificador = lerLinha("Insira o identificador do voo: ");
        if (identificador.isEmpty()) {
            throw new DadosInvalidosException("Campo identificador vazio.");
        }else{
            for(Voo v : Voos.values()) {
                if (v.getIdentificador().equals(identificador)) {
                    voo = v;
                    achouIdM = true;
                }
            }
            if(!achouIdM){
                throw new IdentificadorVooInvalidoException("Identificador inválido.");
            }
        }
        int opcao;
        do {
            opcao = lerInt("Insira a opção de mudança que quer realizar: \n1 - Data\n2 - Horário de Partida\n" +
                    "3 - Horário de Chegada\n0 - Sair.");

            switch (opcao) {
                case 1 -> modificarVooData(voo);
                case 2 -> modificarVooHoraPartida(voo);
                case 3 -> modificarVooHoraChegada(voo);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }


    public void deletarVoo() throws DadosInvalidosException, IdentificadorVooInvalidoException{
        Map<String, Voo> Voos = companhia.getListagemVoos();
        boolean achouIdD = false;
        String identificador = lerLinha("Insira o identificador do voo: ");
        if (identificador.isEmpty()) {
            throw new DadosInvalidosException("Campo identificador vazio.");
        }else {
            for(Voo v : Voos.values()) {
                if (v.getIdentificador().equals(identificador)) {
                    Voos.remove(identificador);
                    achouIdD = true;
                }
            }
            if(!achouIdD){
                    throw new IdentificadorVooInvalidoException("Voo não encontrado");
            }else{
                try {
                    VoosRepository cr = new VoosRepository();
                    cr.salvarDados(companhia);
                    System.out.println("Voo deletado com sucesso");
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                }
            }

        }
    }

    public void deletarVoosAntigos() {
        LocalTime horaAtual = LocalTime.now();
        LocalDate dataAtual = LocalDate.now();

        int horaAtualEmMinutos = horaAtual.getHour() * 60 + horaAtual.getMinute();

        for (Voo voo : companhia.getListagemVoos().values()) {
            int horaVoo = voo.getHorarioPartida().getHour();
            int minutoVoo = voo.getHorarioPartida().getMinute();
            int horaVooEmMinutos = horaVoo * 60 + minutoVoo;

            if (voo.getDataPartida().equals(dataAtual) && (horaVooEmMinutos - horaAtualEmMinutos <= 20))
                companhia.getListagemVoos().remove(voo.getIdentificador());
        }
    }


}