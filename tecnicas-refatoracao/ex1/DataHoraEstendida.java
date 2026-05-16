package br.edu.refactoring.estacionamento;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DataHoraEstendida {

    private LocalDateTime dataHora;

    public DataHoraEstendida(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String formatarDataHora() {
        return dataHora.getDayOfMonth() + "/"
                + dataHora.getMonthValue() + "/"
                + dataHora.getYear() + " "
                + dataHora.getHour() + ":"
                + String.format("%02d", dataHora.getMinute());
    }

    public boolean isHorarioEspecial() {
        DayOfWeek dia = dataHora.getDayOfWeek();

        boolean isDiaUtil = dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;

        boolean isHorarioAlmoco = dataHora.getHour() >= 11 && dataHora.getHour() < 14;

        return isDiaUtil && isHorarioAlmoco;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
