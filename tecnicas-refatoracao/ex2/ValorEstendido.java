package br.edu.refactoring.estacionamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValorEstendido {

    private BigDecimal valor;

    public ValorEstendido(BigDecimal valor) {
        this.valor = valor;
    }

    public String formatarValorEmReais() {
        return "R$ "
                + valor.setScale(2, RoundingMode.HALF_UP)
                .toString()
                .replace(".", ",");
    }

    public boolean isValorAlto() {
        return valor.compareTo(new BigDecimal("50.00")) >= 0;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
