import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LoggerSistema {
    private static LoggerSistema loggerSistema;
    private final DateTimeFormatter dataHoraFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LoggerSistema() {
    }

    public static LoggerSistema getInstance() {
        if (loggerSistema == null) {
            loggerSistema = new LoggerSistema();
        }
        return loggerSistema;
    }

    public void log(String mensagem) {
        String dataHora = LocalDateTime.now().format(dataHoraFormatada);
        System.out.printf("%s -  %s\n", dataHora, mensagem);
    }


}
