package br.edu.refactoring.estacionamento;

public class DadosBancarios {
    private String banco;
    private String agencia;
    private String conta;
    private String metodoPagamentoPreferencial;

    public DadosBancarios(String banco, String agencia, String conta, String metodoPagamentoPreferencial) {
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.metodoPagamentoPreferencial = metodoPagamentoPreferencial;
    }

    public String getDadosCobrancaFormatados() {
        return banco + " | Agência " + agencia + " | Conta " + conta
                + " | Método preferencial: " + metodoPagamentoPreferencial;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public String getMetodoPagamentoPreferencial() {
        return metodoPagamentoPreferencial;
    }

}
