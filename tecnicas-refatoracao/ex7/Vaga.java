package br.edu.refactoring.estacionamento;

import java.time.LocalDateTime;

public class Vaga {

    private String codigo;
    private String setor;
    private boolean coberta;
    private boolean ocupada;



    public Vaga(String codigo, String setor, boolean coberta, boolean ocupada) {
        this.codigo = codigo;
        this.setor = setor;
        this.coberta = coberta;
        this.ocupada = ocupada;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSetor() {
        return setor;
    }

    public boolean isCoberta() {
        return coberta;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String descreverStatus(Vaga vaga) {
        if (vaga.isOcupada() && vaga.isCoberta()) {
            return "ocupada e coberta";
        }

        if (vaga.isOcupada()) {
            return "ocupada";
        }

        if (vaga.isCoberta()) {
            return "livre e coberta";
        }

        return "livre";
    }
}
