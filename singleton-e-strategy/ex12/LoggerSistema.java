public class LoggerSistema {
    private static LoggerSistema loggerSistema;

    private LoggerSistema() {}

    public static LoggerSistema getLoggerSistema() {
        if (loggerSistema == null) {
            loggerSistema = new LoggerSistema();
        }
        return loggerSistema;
    }

    public void registrarRelatorio(String formatoRelatorio) {
        System.out.printf("Relatório gerado no formato %s\n", formatoRelatorio);
    }
}
