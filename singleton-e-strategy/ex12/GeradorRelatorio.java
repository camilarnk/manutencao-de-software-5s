public class GeradorRelatorio {
    private Relatorio relatorio;

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public void gerarRelatorio(String conteudo) {
        if (relatorio == null) {
            throw new IllegalStateException("Tipo de relatório não definido");
        }

        relatorio.gerarRelatorio(conteudo);

        LoggerSistema.getLoggerSistema().registrarRelatorio(relatorio.getFormato());
    }
}
