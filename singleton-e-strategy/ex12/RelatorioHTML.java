public class RelatorioHTML implements Relatorio {
    @Override
    public void gerarRelatorio(String conteudo) {
        System.out.printf("Gerando relatório em HTML: %s\n", conteudo);
    }

    @Override
    public String getFormato() {
        return "HTML";
    }
}
