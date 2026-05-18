package br.edu.refactoring.estacionamento;

import java.time.LocalDateTime;

public class Veiculo {

    private String placa;
    private String modelo;
    private String cor;

    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaidaPrevista;

    private DadosSeguradora dadosSeguradora;


    public Veiculo(String placa, String modelo, String cor,
                   LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaidaPrevista,
                   DadosSeguradora dadosSeguradora) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaidaPrevista = dataHoraSaidaPrevista;
        this.dadosSeguradora = dadosSeguradora;
    }

    public void imprimirDados() {
        System.out.println("Veículo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Cor: " + cor);
        System.out.println("Entrada registrada: " + dataHoraEntrada);
        System.out.println("Saída prevista: " + dataHoraSaidaPrevista);
        System.out.println("Seguro: " + dadosSeguradora.getDadosSeguroFormatados());
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaidaPrevista() {
        return dataHoraSaidaPrevista;
    }

}
