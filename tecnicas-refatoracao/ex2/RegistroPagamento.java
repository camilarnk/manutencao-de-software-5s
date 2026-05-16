package br.edu.refactoring.estacionamento;

import java.math.BigDecimal;

public class RegistroPagamento {

    private TicketEstacionamento ticket;
    private Cliente cliente;
    private BigDecimal valor;

    public RegistroPagamento(TicketEstacionamento ticket, Cliente cliente, BigDecimal valor) {
        this.ticket = ticket;
        this.cliente = cliente;
        this.valor = valor;
    }

    public void imprimirComprovante() {
        ValorEstendido valorEstendido = new ValorEstendido(valor);

        System.out.println("Pagamento do ticket: " + ticket.getCodigo());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Valor: " + valorEstendido.formatarValorEmReais());

        if (valorEstendido.isValorAlto()) {
            System.out.println("Classificação: pagamento de alto valor");
        } else {
            System.out.println("Classificação: pagamento comum");
        }
    }

    public TicketEstacionamento getTicket() {
        return ticket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
